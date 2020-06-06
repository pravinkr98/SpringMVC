package com.ps.config;

import java.util.Calendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.ps.service")
public class ServiceConfig {
	
	@Bean
	public Calendar getInstance() {
		Calendar cal=null;
		cal=Calendar.getInstance();
		return cal;
	}

}
