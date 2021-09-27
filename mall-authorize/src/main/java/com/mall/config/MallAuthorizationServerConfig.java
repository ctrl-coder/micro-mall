package com.mall.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Order(1)
@Configuration
@EnableAuthorizationServer
public class MallAuthorizationServerConfig {
}
