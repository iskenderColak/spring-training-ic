package com.icolak.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.icolak")
@ComponentScan(basePackages = {"com.icolak.proxy", "com.icolak.service", "com.icolak.repository"})
public class CommentConfig {
}
