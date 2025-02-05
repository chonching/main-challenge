package com.directa24.main_challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MainChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainChallengeApplication.class, args);
	}

}
