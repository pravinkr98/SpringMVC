package com.ps.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ps.command.UserCommand;
import com.ps.dto.UserDTO;
import com.ps.service.LoginMgmtService;

@Controller
public class LoginController {
	
	public LoginController() {
		System.out.println("LoginController:: 0-param constructor");
	}
	
	@Autowired
	private LoginMgmtService service;

	@GetMapping("/login.htm")
	public String showHome(@ModelAttribute("userCmd")UserCommand cmd) {
		System.out.println("LoginController.showHome()");
		return "login_form";
	}
	
	@PostMapping("/login.htm")
	public String processLogin(Map<String,Object> map,@ModelAttribute("userCmd")UserCommand cmd) {
		System.out.println("LoginController.processLogin()");
		UserDTO dto=null;
		String msg=null;
		//Keep command object into dto
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		msg=service.authentication(dto);
		//Keep data into model object
		map.put("loginMsg", msg);
		//return lvn
		return "login_form";
	}
}
