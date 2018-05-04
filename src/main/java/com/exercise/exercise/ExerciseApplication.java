package com.exercise.exercise;

import com.exercise.exercise.exception.CustomError;
import com.exercise.exercise.exception.LocalRuntimeException;
import com.exercise.exercise.model.UserInfo;
import com.exercise.exercise.util.CustomJsonConvert;
import com.exercise.exercise.util.RedisService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@MapperScan("com.exercise.exercise.mapper")
public class ExerciseApplication{

    public static void main(String[] args) {
        SpringApplication.run(ExerciseApplication.class, args);
    }


//    @Bean
//    public WebMvcConfigurer mvcConfigurer(CustomJsonConvert convert, HandlerMethodArgumentResolver userInfoArgumentResolver,
//                                          HandlerInterceptor authenticationInterceptor){
//        return new WebMvcConfig(convert,userInfoArgumentResolver,authenticationInterceptor);
//    }




    @Configuration
    public static class UserInfoValidationConfigurer implements InitializingBean{
        private static final String COOKIE_KEY = "session_id";
        private final RedisService redisService;
        private List<String> excludeUrls;


        private String excludeUrl = "/login;/register";

        public static ThreadLocal<UserInfo> userInfoHolder = new ThreadLocal<>();

        @Autowired
        public UserInfoValidationConfigurer(RedisService redisService) {
            this.redisService = redisService;
        }

        @Bean
        public HandlerInterceptor authenticationInterceptor(){
            return new HandlerInterceptorAdapter() {
                @Override
                public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
                    String requestURI = request.getRequestURI();
                    Cookie cookie = getCookie(request, COOKIE_KEY);
                    if (cookie == null) {
                        if (excludeUrls.contains(requestURI)) {
                            userInfoHolder.set(new UserInfo(Boolean.FALSE));
                        } else {
                            throw new LocalRuntimeException(CustomError.SESSION_NOT_FOUND);
                        }
                    } else {
                        String authToken = cookie.getValue();
                        UserInfo userInfo = redisService.getFromCache(authToken, UserInfo.class);
                        if (userInfo != null) {
                            redisService.expandExpireTime(authToken, 180, TimeUnit.DAYS);
                            userInfoHolder.set(userInfo);
                        } else if (excludeUrls.contains(requestURI)) {
                            userInfoHolder.set(new UserInfo(Boolean.FALSE));
                        } else {
                            throw new LocalRuntimeException(CustomError.SESSION_TIMEOUT);
                        }
                    }
                    return true;
                }

                @Override
                public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
                    userInfoHolder.remove();
                }
            };
        }


        private static Cookie getCookie(HttpServletRequest request, String name) {
            Cookie[] cookies = request.getCookies();
            if (ArrayUtils.isEmpty(cookies) || StringUtils.isBlank(name)) {
                return null;
            }

            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
            return null;
        }


        @Override
        public void afterPropertiesSet() {
            excludeUrls = Arrays.asList(excludeUrl.split(";"));
        }

        @Bean
        public HandlerMethodArgumentResolver userInfoArgumentResolver() {
            return new HandlerMethodArgumentResolver() {

                ///判断是否支持要转换的参数类型,这里默认全部支持
                @Override
                public boolean supportsParameter(MethodParameter parameter) {
                    return true;
                }

                //当支持后进行相应的转换
                @Override
                public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
                    return userInfoHolder.get();
                }
            };
        }
    }
}
