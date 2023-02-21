package com.sunil.StaffMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()

public class StaffMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffMicroserviceApplication.class, args);
	}

}
