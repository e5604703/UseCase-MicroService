package com.casestudy.subscriptionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableEurekaClient
@EnableFeignClients
public class SubscriptionserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionserviceApplication.class, args);
	}

}
