package com.ps.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AopConfig {
	
	public AopConfig() {
		System.out.println("AopConfig:: 0-param constructor");
	}
	
	@Autowired
	private DataSource ds;

	@Bean(name="dsTxMgmr")
	public DataSourceTransactionManager createDsTxMgmr() {
		System.out.println("AopConfig.createDsTxMgmr()");
		DataSourceTransactionManager dsTxMgmr=null;
		dsTxMgmr=new DataSourceTransactionManager(ds);
		return dsTxMgmr;
	}
}
