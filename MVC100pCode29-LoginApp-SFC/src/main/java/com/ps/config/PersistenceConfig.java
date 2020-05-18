package com.ps.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.ps.dao")
public class PersistenceConfig {
	
	public PersistenceConfig() {
		System.out.println("PersistenceConfig:: 0-param constructor");
	}
	
	@Bean
	public JndiObjectFactoryBean createJOFB() {
		System.out.println("PersistenceConfig.createJOFB()");
		JndiObjectFactoryBean jofb=null;
		jofb=new JndiObjectFactoryBean();
		jofb.setJndiName("java:/comp/env/DsJndi");
		return jofb;
	}
	
	@Bean
	public JdbcTemplate createJdbcTemplate() {
		System.out.println("PersistenceConfig.createJdbcTemplate()");
		JdbcTemplate jt=null;
		jt=new JdbcTemplate((DataSource) createJOFB().getObject());
		return jt;		
	}

}
