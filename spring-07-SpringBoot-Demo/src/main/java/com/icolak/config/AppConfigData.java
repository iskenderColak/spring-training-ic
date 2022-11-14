package com.icolak.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// @Component (@Configuration contains @Component)
@Data
@Configuration // instead of component @Configuration makes more sense for carrying data
public class AppConfigData {

    @Value("${username}")
    private String userName;

    @Value("${password}")
    private String password;

    @Value("${url}")
    private String url;
}
