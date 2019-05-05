package com.wchuang.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean
{
    @Bean
    @LoadBalanced //获得RestTemplate时加入Ribbon的负载均衡配置
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}