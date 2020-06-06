package com.ps.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String USER_BY_UNAME="SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?";
	private static final String USER_BY_ROLE="SELECT UNAME,ROLE FROM USER_ROLE WHERE UNAME=?";
	
	@Autowired
	private DataSource ds;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds).usersByUsernameQuery(USER_BY_UNAME).authoritiesByUsernameQuery(USER_BY_ROLE);
				
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home.htm").access("permitAll").antMatchers("/wish.htm").access("hasAnyRole('ROLE_BANK_CUSTOMER,ROLE_BANK_EMPLOYEE')").and().formLogin().and().rememberMe().and().logout().logoutSuccessUrl("/home.htm").and().exceptionHandling().accessDeniedPage("/access_denied.jsp").and().sessionManagement().invalidSessionUrl("/home.htm").maximumSessions(2).expiredUrl("/home.htm").maxSessionsPreventsLogin(true);
		
	}

}
