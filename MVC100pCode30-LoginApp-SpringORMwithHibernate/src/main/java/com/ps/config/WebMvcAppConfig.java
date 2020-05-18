package com.ps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

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
		InternalResourceViewResolver irvr=null;
		irvr=new InternalResourceViewResolver();
		irvr.setViewClass(JstlView.class);
		irvr.setPrefix("/WEB-INF/pages/");
		irvr.setSuffix(".jsp");
		return irvr;
	}

}
