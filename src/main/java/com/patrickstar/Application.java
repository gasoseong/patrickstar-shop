package com.patrickstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.patrickstar.tenbyten.TenByTen;
import com.patrickstar.tenbyten.TenByTenController;

@SpringBootApplication // @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}