package com.example.rest4.model;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
public class ApplicationConfiguration {

    @Bean
    RedissonClient config() {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient client = Redisson.create(config);
        return client;
    }

    @Bean
    RMap<String, User> map(RedissonClient client) {
        RMap<String, User> map = client.getMap("user");
        return map;
    }

}
