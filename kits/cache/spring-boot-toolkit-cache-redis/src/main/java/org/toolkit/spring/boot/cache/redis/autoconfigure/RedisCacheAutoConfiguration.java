package org.toolkit.spring.boot.cache.redis.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@AutoConfiguration
@Slf4j
public class RedisCacheAutoConfiguration {

    @Resource
    private ObjectMapper objectMapper;

    @Bean
    @ConditionalOnBean(name = "localLettuceConnectionFactory")
    public RedisTemplate<String, String> localRedisTemplate(LettuceConnectionFactory localLettuceConnectionFactory) {
		val valueSerializer = new GenericJackson2JsonRedisSerializer(objectMapper);
        return new RedisTemplate<>(){{
			setConnectionFactory(localLettuceConnectionFactory);
			setKeySerializer(new StringRedisSerializer());
			setValueSerializer(valueSerializer);
			setEnableTransactionSupport(true);
			setHashValueSerializer(valueSerializer);
			afterPropertiesSet();
		}};
    }
}
