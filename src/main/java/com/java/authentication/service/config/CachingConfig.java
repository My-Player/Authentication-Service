package com.java.authentication.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@EnableScheduling
public class CachingConfig {

    @Autowired
    private CacheManager cacheManager;

    @Bean
    public CacheManager cacheManager(){
        cacheManager = new ConcurrentMapCacheManager("otp");
        return cacheManager;
    }

    @Scheduled(initialDelay = 0, fixedRate = 120000)
    public void evictCache(){cacheManager.getCache("otp").clear();}

}
