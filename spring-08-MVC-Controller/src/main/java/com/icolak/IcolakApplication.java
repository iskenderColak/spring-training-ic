package com.icolak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
@SpringBootApplication(exclude = {AopAutoConfiguration.class})
public class IcolakApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcolakApplication.class, args);
	}

}
