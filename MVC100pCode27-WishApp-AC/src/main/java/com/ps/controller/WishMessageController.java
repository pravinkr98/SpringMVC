package com.ps.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ps.service.WishMessageService;

@Controller
public class WishMessageController {
	
	@Autowired
	private WishMessageService service;

	public WishMessageController() {
		System.out.println("WishMessageController:: 0-param constructor");
	}
	
	@RequestMapping("/home.htm")
	public String showHome() {
		System.out.println("WishMessageController.showHome()");
		//return lvn
		return "welcome";
	}
	
	@RequestMapping("/wish.htm")
	public String showWishMessage(Map<String,Object> map) {
		String msg=null;
		System.out.println("WishMessageController.showWishMessage()");
		//use service
		msg=service.wishMessageGenerator();
		//keep message in model object
		map.put("wishMsg",msg);
		//return lvn
		return "result";
	}
}
