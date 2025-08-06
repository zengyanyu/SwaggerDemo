package com.example.config;


import com.example.entity.UserInfo;

/**
 * 用户上下文占位符
 */
public class UserContextHolder {

    private static final ThreadLocal<UserInfo> userContextHolder = new ThreadLocal<>();

    public static void setUserContext(UserInfo userContext) {
        userContextHolder.set(userContext);
    }

    public static UserInfo getUserContext() {
        return userContextHolder.get();
    }

    public static void clear() {
        userContextHolder.remove();
    }
}
