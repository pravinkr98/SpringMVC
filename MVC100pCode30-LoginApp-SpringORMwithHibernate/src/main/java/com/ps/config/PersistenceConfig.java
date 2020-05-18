package com.ps.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.ps.bo.UserBO;


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
	
	@Bean(name="lsfb")
	public LocalSessionFactoryBean createLSFB() {
		System.out.println("PersistenceConfig.createLSFB()");
		LocalSessionFactoryBean factory=null;
		Properties props=null;
		
		factory=new LocalSessionFactoryBean();
		factory.setDataSource((DataSource) createJOFB().getObject());
		factory.setAnnotatedClasses(UserBO.class);
		factory.setAnnotatedPackages("com.ps.bo");
		props=new Properties();
		props.setProperty("show_sql", "true");
		props.setProperty("dialect", "org.hibernate.dialect.Oracle10gDialect");
		factory.setHibernateProperties(props);
		return factory;
	}
	
	@Bean(name="ht")
	public HibernateTemplate createHT() {
		return new HibernateTemplate(createLSFB().getObject());
	}

}
