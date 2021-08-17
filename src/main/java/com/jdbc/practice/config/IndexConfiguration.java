package com.jdbc.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class IndexConfiguration {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
