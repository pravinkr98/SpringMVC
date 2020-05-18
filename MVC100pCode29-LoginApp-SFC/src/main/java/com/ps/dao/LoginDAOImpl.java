package com.ps.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ps.bo.UserBO;

@Repository("userDao")
public final class LoginDAOImpl implements LoginDAO {
	private static final String AUTH_QUERY="SELECT COUNT(*) FROM USER_INFO WHERE USERNAME=? AND PASSWORD=?";
	
	public LoginDAOImpl() {
		System.out.println("LoginDAOImpl:: 0-param constructor");
	}
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int validate(UserBO bo) {
		System.out.println("LoginDAOImpl.validate()");
		int count=0;
		//use JdbcTemplate
		count=jt.queryForObject(AUTH_QUERY, Integer.class, bo.getUserName(),bo.getPassword());
		return count;
	}

}
