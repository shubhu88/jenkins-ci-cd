//package com.irctc_backend.util;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//
//@Configuration
//@EnableRedisRepositories
//public class RedisConfig {
//	
//	@Bean
//	public JedisConnectionFactory connectionFactory() {
//		//if we have redis external server configuration 
////		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
////		configuration.setHostName("10.9.64.61");
////		configuration.setPort(8180);
//		return new JedisConnectionFactory();
//	}
//	
//	@Bean
//	public RedisTemplate<Object, Object> redisTemplate(){
//		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(connectionFactory());
//		return redisTemplate;
//	}
//
//}
