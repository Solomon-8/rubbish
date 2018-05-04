package com.exercise.exercise;

import com.exercise.exercise.model.UserInfo;
import com.exercise.exercise.util.CustomJsonConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author Solomon
 * @date 2018/4/29
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private CustomJsonConvert convert;
    private HandlerMethodArgumentResolver userInfoArgumentResolver;
    private HandlerInterceptor authenticationInterceptor;

    @Autowired
    public WebMvcConfig(CustomJsonConvert convert, HandlerMethodArgumentResolver userInfoArgumentResolver, HandlerInterceptor authenticationInterceptor) {
        this.convert = convert;
        this.userInfoArgumentResolver = userInfoArgumentResolver;
        this.authenticationInterceptor = authenticationInterceptor;
    }

    public WebMvcConfig() {
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(this.convert);
        super.configureMessageConverters(converters);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(this.userInfoArgumentResolver);
        super.addArgumentResolvers(resolvers);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.authenticationInterceptor).addPathPatterns("/**").excludePathPatterns("/error", "/login", "/register");
        super.addInterceptors(registry);
    }
}
