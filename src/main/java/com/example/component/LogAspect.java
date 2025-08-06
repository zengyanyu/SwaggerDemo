package com.example.component;

import com.example.config.LogRecord;
import com.example.config.UserContextHolder;
import com.example.entity.LogRecordEntity;
import com.example.entity.UserInfo;
import com.example.service.ILogRecordService;
import com.example.util.DateUtils;
import com.example.util.HttpRequestUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 自定义日志切面
 */
// 标记当前类是一个切面类
@Aspect
@Component
public class LogAspect {

    private ThreadLocal<LogRecordEntity> threadLocal = new ThreadLocal<>();
    @Resource
    private ILogRecordService recordService;

    /**
     * 定义切入点，这里我们使用AOP切入自定义【@LogRecord】注解的方法
     */
    @Pointcut("@annotation(com.example.config.LogRecord)")
    public void pointCut() {
    }

    /**
     * 前置通知,【执行Controller方法之前】执行该通知方法
     */
    @Before("pointCut()")
    public void beforeAdvice() {
    }

    /**
     * 后置通知,【Controller方法执行完成,返回方法的返回值之前】执行该通知方法
     */
    @After("pointCut()")
    public void afterAdvice() {
    }

    /**
     * 环绕通知,执行Controller方法的前后执行
     *
     * @param joinPoint 连接点
     */
    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取当前请求对象
        HttpServletRequest request = HttpRequestUtil.getRequest();
        if (request == null) {
            return null;
        }
        // 获取请求相关信息
        LogRecordEntity entity = new LogRecordEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setPath(request.getRequestURI());
        entity.setMethod(request.getMethod());
        entity.setRequestIp(request.getRemoteHost());
        // 请求开始时间
        entity.setRequestTime(DateUtils.getCurrentTime());

        // 反射获取调用方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if (method.isAnnotationPresent(LogRecord.class)) {
            // 获取注解信息
            LogRecord annotation = method.getAnnotation(LogRecord.class);
            entity.setOperateName(annotation.value());
        }
        // 获取全限定类名称
        String name = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String qualifiedName = name + ":" + methodName;
        entity.setQualifiedName(qualifiedName);

        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        // 创建参数名称和值的映射
        Map<String, Object> paramMap = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], args[i]);
        }

        // 获取请求参数
        entity.setInputParam(String.valueOf(paramMap));
        // 设置局部变量
        threadLocal.set(entity);

        // 调用Controller方法
        Object ret = joinPoint.proceed();
        return ret;
    }

    /**
     * 返回值通知,Controller执行完成之后,返回方法的返回值时候执行
     *
     * @param ret 返回值的名称
     */
    @AfterReturning(pointcut = "pointCut()", returning = "ret")
    public Object afterReturning(Object ret) {
        // 获取日志实体对象
        LogRecordEntity entity = this.getEntity();
        if (null != ret) {
            JSONObject jsonObject = new JSONObject(ret);
            String outputParam = jsonObject.toString();
//             entity.setOutputParam(outputParam); // 保存响应参数
        }
        entity.setStatus("成功"); // 设置成功标识
        this.recordService.save(entity);
        // 一定要删除 ThreadLocal 变量
        threadLocal.remove();
        return ret;
    }

    /**
     * 异常通知,当Controller方法执行过程中出现异常时候,执行该通知
     *
     * @param ex 异常名称
     */
    @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    public void throwingAdvice(Throwable ex) {
        // 获取日志实体对象
        LogRecordEntity entity = getEntity();
//        StringWriter errorMsg = new StringWriter();
//        ex.printStackTrace(new PrintWriter(errorMsg, true));
        entity.setErrorMsg(ex.getMessage()); // 保存响应参数
        entity.setStatus("失败"); // 设置成功标识
        this.recordService.save(entity);
        // 一定要删除 ThreadLocal 变量
        threadLocal.remove();
    }

    private LogRecordEntity getEntity() {
        // 获取局部变量
        LogRecordEntity entity = threadLocal.get();
        entity.setResponseTime(DateUtils.getCurrentTime());
        // 设置操作账号
        UserInfo userContext = UserContextHolder.getUserContext();
        if (null != userContext) {
            entity.setOperateUsername(userContext.getUsername());
        }
        return entity;
    }
}
