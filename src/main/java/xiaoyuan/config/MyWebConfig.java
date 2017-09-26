package com.xiaoyuan.config;

import com.xiaoyuan.interceptor.LogHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by dnys on 2017/9/21.
 */
@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter {

    /**
     * 注册 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogHandlerInterceptor());
    }

}