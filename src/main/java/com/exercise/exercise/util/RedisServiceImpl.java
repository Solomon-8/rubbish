package com.exercise.exercise.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Solomon
 * @date 2018/4/29
 */
@Component
public class RedisServiceImpl implements RedisService{

    private static final long DEFAULT_TIMEOUT = 60;
    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.DAYS;
    private final RedisTemplate<String,String> template;

    @Autowired
    public RedisServiceImpl(RedisTemplate<String, String> template) {
        this.template = template;
    }


    @Override
    public <T> T getFromCache(String key, TypeReference<T> typeReference) {
        String string = template.boundValueOps(key).get();
        if (StringUtils.isBlank(string)) {
            return null;
        }

        return JSON.parseObject(string, typeReference);
    }

    @Override
    public <T> T getFromCache(String key, Class<T> clazz) {
        String string = template.boundValueOps(key).get();
        if (StringUtils.isBlank(string)) {
            return null;
        }

        return JSON.parseObject(string, clazz);
    }

    @Override
    public void removeFromCache(String key) {
        template.delete(key);
    }

    @Override
    public void removeFromCacheAsync(String key) {
        CompletableFuture.runAsync(() ->
                template.delete(key)
        );
    }

    @Override
    public <T> void setToCache(String key, T value, long timeout, TimeUnit timeUnit) {
        String content = JSON.toJSONString(value);
        setToCache(key, content, timeout, timeUnit);
    }


    @Override
    public <T> void setToCache(String key, T value, long timeout) {
        setToCache(key, value, timeout, DEFAULT_TIME_UNIT);
    }

    @Override

    public <T> void setToCache(String key, T value) {
        setToCache(key, value, DEFAULT_TIMEOUT);
    }

    @Override
    public <T> void setToCacheAsync(String key, T value, long timeout, TimeUnit timeUnit) {
        String content = JSON.toJSONString(value);
        setToCacheAsync(key, content, timeout, timeUnit);
    }

    @Override
    public <T> void setToCacheAsync(String key, T value, long timeout) {
        setToCacheAsync(key, value, timeout, DEFAULT_TIME_UNIT);
    }

    @Override
    public <T> void setToCacheAsync(String key, T value) {
        setToCacheAsync(key, value, DEFAULT_TIMEOUT);
    }

    @Override
    public String getFromCache(String key) {
        return template.boundValueOps(key).get();
    }

    @Override
    public void setToCache(String key, String value, long timeout, TimeUnit timeUnit) {
        template.boundValueOps(key).set(value, timeout, timeUnit);
    }

    @Override
    public void setToCacheAsync(String key, String value, long timeout, TimeUnit timeUnit) {
        template.boundValueOps(key).set(value, timeout, timeUnit);
//        CompletableFuture.runAsync(() -> {
//
//        });
    }

    @Override
    public void setToCache(String key, String value, long timeout) {
        setToCache(key, value, timeout, DEFAULT_TIME_UNIT);
    }

    @Override
    public void setToCacheAsync(String key, String value, long timeout) {
        setToCacheAsync(key, value, timeout, DEFAULT_TIME_UNIT);
    }

    @Override
    public void setToCache(String key, String value) {
        setToCache(key, value, DEFAULT_TIMEOUT);
    }

    @Override
    public void setToCacheAsync(String key, String value) {
        setToCacheAsync(key, value, DEFAULT_TIMEOUT);
    }

    @Override
    public void expandExpireTime(String key, long timeout, TimeUnit timeUnit) {
        template.boundValueOps(key).expire(timeout, timeUnit);
    }
}
