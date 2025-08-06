package com.example.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description HTTP请求的工具类, 用于获取Request、Response相关信息
 */
public final class HttpRequestUtil {

    private HttpRequestUtil() {
    }

    /**
     * 从 SpringBoot 中获取 Request 请求对象
     *
     * @return 返回当前请求的 Request 对象
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = getServletRequestAttributes();
        return attributes.getRequest();
    }

    /**
     * 从 SpringBoot 中获取 Response 请求对象
     *
     * @return 返回当前请求的 Response 对象
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes attributes = getServletRequestAttributes();
        return attributes.getResponse();
    }

    /**
     * 获取ServletRequestAttributes（Servlet请求属性）
     *
     * @return
     */
    private static ServletRequestAttributes getServletRequestAttributes() {
        // org.springframework.web.context.request
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        }
        return (ServletRequestAttributes) requestAttributes;
    }

}
