package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * 安全配置
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Resource
    private JwtAuthFilter jwtAuthFilter;

    @Override
    public void configure(WebSecurity web) {
        // 放行Swagger相关路径
        web.ignoring().antMatchers(
                "/favicon.ico",
                "/doc.html",
                "/swagger-ui.html",
                "/v2/api-docs",
                "/swagger-resources/**",
                "/webjars/**",
                "/v3/api-docs/**",
                "/druid/**"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and() // 启用 CORS 支持
                .csrf().disable() // 禁用 CSRF 保护
                .authorizeRequests()
                // 不需要验证的接口
                .antMatchers("/index.html",
                        "/getPerson", "/getPersonByYamlData", "/log-record/export"
                ).permitAll()
                .antMatchers("/**").authenticated() // 其他所有接口需要认证
                .anyRequest().authenticated() // 所有未匹配的请求也需要认证
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
    }

}
