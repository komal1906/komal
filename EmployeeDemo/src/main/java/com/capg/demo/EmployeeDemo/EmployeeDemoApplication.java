package com.capg.demo.EmployeeDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com.capg.demo.bean")
@ComponentScan("com.capg.demo.controller")
@ComponentScan("com.capg.demo.repo")
@ComponentScan("com.capg.demo.service")
@ComponentScan("com.capg.demo.exception")
@SpringBootApplication
public class EmployeeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDemoApplication.class, args);
	}

}
