package com.cake.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Main class to run Cake Manager application
 * @author Sanjay
 *
 */
@SpringBootApplication
public class ManagerApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
		
		}

}
