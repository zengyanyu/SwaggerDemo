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
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        return attributes.getRequest();
    }

    /**
     * 从 SpringBoot 中获取 Response 请求对象
     *
     * @return 返回当前请求的 Response 对象
     */
    public static HttpServletResponse getResponse() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        return attributes.getResponse();
    }

}
