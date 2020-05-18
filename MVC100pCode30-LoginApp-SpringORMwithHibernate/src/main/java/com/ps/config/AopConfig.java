package com.ps.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AopConfig {
	
	public AopConfig() {
		System.out.println("AopConfig:: 0-param constructor");
	}
	
	@Autowired
	private SessionFactory factory;

	@Bean(name="hbTxMgmr")
	public HibernateTransactionManager createHBTxMgmr() {
		return new HibernateTransactionManager(factory);
	}
}
