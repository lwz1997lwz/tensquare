package com.tensquare.qa.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @program: tensquare_parent
 * @description: 用于配置拦截器
 * @author: Linweizhe
 * @create: 2019-03-02 21:12
 **/
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(jwtInterceptor).
                addPathPatterns("/**").
                excludePathPatterns("/**/login");
    }
}
