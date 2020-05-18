package com.ps.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ps.bo.UserBO;

@Repository("userDao")
public final class LoginDAOImpl implements LoginDAO {
	private static final String HQL_AUTH_QUERY="SELECT COUNT(*) FROM UserBO WHERE userName=:un AND password=:pwd";
	
	public LoginDAOImpl() {
		System.out.println("LoginDAOImpl:: 0-param constructor");
	}
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public long validate(UserBO bo) {
		System.out.println("LoginDAOImpl.validate()");
		List<?> list=null;
		//use JdbcTemplate
		list=ht.findByNamedParam(HQL_AUTH_QUERY, new String[] {"un","pwd"}, new Object[] {bo.getUserName(),bo.getPassword()});
		return (long) list.get(0);
	}

}
