package com.jdbc.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;
@EnableAspectJAutoProxy
@Configuration
public class IndexConfiguration {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
