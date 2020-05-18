package com.ps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ps.controller")
public class WebMvcAppConfig {
	
	public WebMvcAppConfig() {
		System.out.println("WebMvcAppConfig:: 0-param constructor");
	}
	
	@Bean
	public InternalResourceViewResolver createIRVR() {
		System.out.println("WebMvcAppConfig.createIRVR()");
		InternalResourceViewResolver resolver=null;
		
		//create object of view rsolver
		resolver=new InternalResourceViewResolver();
		//set prefix and suffix
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		//return view object
		return resolver;
	}

}
