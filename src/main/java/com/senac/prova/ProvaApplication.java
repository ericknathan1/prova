package com.senac.prova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProvaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaApplication.class, args);
	}

}
