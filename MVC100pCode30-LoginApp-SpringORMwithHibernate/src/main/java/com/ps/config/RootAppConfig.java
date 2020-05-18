package com.ps.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceConfig.class,ServiceConfig.class,AopConfig.class})
public class RootAppConfig {
	
	public RootAppConfig() {
		System.out.println("RootAppConfig:: 0-param constructor");
	}

}
