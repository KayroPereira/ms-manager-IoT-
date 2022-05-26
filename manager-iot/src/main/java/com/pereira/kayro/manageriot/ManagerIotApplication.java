package com.pereira.kayro.manageriot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com/pereira/kayro/manageriot/entities")
public class ManagerIotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerIotApplication.class, args);
	}

}
