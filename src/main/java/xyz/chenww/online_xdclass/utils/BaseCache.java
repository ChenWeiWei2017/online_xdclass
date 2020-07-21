package xyz.chenww.online_xdclass.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述：基于Guava的缓存工具类
 *
 * @author chenweiwei
 * @since 2020/7/21
 */
@Component
public class BaseCache {

    private Cache<String, Object> tenMinutesCache = CacheBuilder.newBuilder()
            // 设置缓存初始大小，应合理设置，后续会扩容
            .initialCapacity(10)
            // 设置缓存的最大容量，过大会导致内存溢出
            .maximumSize(100)
            // 并发数，允许有5个线程同时写缓存
            .concurrencyLevel(5)
            // 过期时间，写入后10分钟过期
            .expireAfterAccess(10, TimeUnit.MINUTES)
            // 统计缓存命中率
            .recordStats()
            .build();

    private Cache<String, Object> OneHourCache = CacheBuilder.newBuilder()
            // 设置缓存初始大小，应合理设置，后续会扩容
            .initialCapacity(10)
            // 设置缓存的最大容量，过大会导致内存溢出
            .maximumSize(100)
            // 并发数，允许有5个线程同时写缓存
            .concurrencyLevel(5)
            // 过期时间，写入后10分钟过期
            .expireAfterAccess(1, TimeUnit.HOURS)
            // 统计缓存命中率
            .recordStats()
            .build();

    public Cache<String, Object> getTenMinutesCache() {
        return tenMinutesCache;
    }

    public void setTenMinutesCache(Cache<String, Object> tenMinutesCache) {
        this.tenMinutesCache = tenMinutesCache;
    }

    public Cache<String, Object> getOneHourCache() {
        return OneHourCache;
    }

    public void setOneHourCache(Cache<String, Object> oneHourCache) {
        OneHourCache = oneHourCache;
    }
}
