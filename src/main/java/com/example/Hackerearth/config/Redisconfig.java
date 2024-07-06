package com.example.Hackerearth.config;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
@Configuration
public class Redisconfig {
	  @Value("${redis.host}")
	  private String redisHost;

	  @Value("${redis.port}")
	  private int redisPort;

	  @Bean
	  public LettuceConnectionFactory redisConnectionFactory() {
	    RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);
	    return new LettuceConnectionFactory(configuration);
	    
	  }
	  
	  @Bean
	  public CacheManager getCacheManager(RedisConnectionFactory rs) {
	//  return RedisCacheManager.create(rs);
		  return RedisCacheManager.builder(redisConnectionFactory()).withCacheConfiguration("logins1",getconfig(200))
				  .build();
	  }
	  
	  private RedisCacheConfiguration getconfig(int seconds) {
		  return RedisCacheConfiguration
				  .defaultCacheConfig()
				  .entryTtl(Duration.ofSeconds(seconds));
	  }
}
