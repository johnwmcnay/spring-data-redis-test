package com.example.redistest.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {


        @Bean
        public LettuceConnectionFactory redisConnectionFactory() {

            return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
        }

}