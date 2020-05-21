package com.ps.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ps.bo.UserBO;
import com.ps.dao.LoginDAO;
import com.ps.dto.UserDTO;

@Service("loginService")
public class LoginMgmtServiceImpl implements LoginMgmtService {
	
	public LoginMgmtServiceImpl() {
		System.out.println("LoginMgmtServiceImpl:: 0-param constructor");
	}
	
	@Autowired
	private LoginDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,transactionManager = "transactionManager")
	public String authentication(UserDTO dto) {
		System.out.println("LoginMgmtServiceImpl.authentication()");
		int count=0;
		UserBO bo=null;
		//Convert dto to bo object
		bo=new UserBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.validate(bo);
		//return result
		return count==0?"<h1 style='color:red;text-align:center'>Invalid Credentials</h1>":"<h1 style='color:green;text-align:center'>Valid Credentials</h1>";
	}

}
