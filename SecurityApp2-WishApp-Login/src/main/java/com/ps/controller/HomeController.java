package com.ps.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ps.service.WishMessageService;

@Controller
public class HomeController {
	
	@Autowired
	private WishMessageService service;
	
	@RequestMapping("/home.htm")
	public String homeHandler() {
		return "welcome";
	}
		
	@RequestMapping("/wish.htm")
	public String process(Map<String,Object> map) {
		String msg=null;
		//use service
		msg=service.generateWishMessage();
		//put model data
		map.put("wMsg",msg);
		//return logical view name
		return "result";
	}
	
	}
