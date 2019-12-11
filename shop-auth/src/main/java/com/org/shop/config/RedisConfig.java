package com.org.shop.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Administrator
 * @version $Id: com.yl.esl.common.config.RedisConfig.java V-0.1 2019/2/19 0019 14:50 Administrator Exp $$
 * @description xxx
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

	private static final FastJsonRedisSerializer<Object> fastjsonSerializer = new FastJsonRedisSerializer<>(Object.class);
	private static final StringRedisSerializer stringSerializer = new StringRedisSerializer();

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	@Override
	@Bean
	public CacheManager cacheManager() {
		RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisConnectionFactory).build();
		return redisCacheManager;
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate() {
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
		stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
//		stringRedisTemplate.setValueSerializer(fastjsonSerializer);
		stringRedisTemplate.afterPropertiesSet();
		return stringRedisTemplate;
	}

	@Bean
	public RedisTemplate<Object, Object> redisTemplate() {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		redisTemplate.setKeySerializer(stringSerializer);
		redisTemplate.setValueSerializer(fastjsonSerializer);
		redisTemplate.setHashKeySerializer(stringSerializer);
//		redisTemplate.setHashValueSerializer(fastjsonSerializer);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
}
