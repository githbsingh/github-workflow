package com.mmm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UserProfileManagementApplication extends SpringBootServletInitializer {
	private static final Logger LOG = LoggerFactory.getLogger(UserProfileManagementApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(UserProfileManagementApplication.class, args);
		LOG.info("--Application User Profile Management Started--");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UserProfileManagementApplication.class);
	}
}
