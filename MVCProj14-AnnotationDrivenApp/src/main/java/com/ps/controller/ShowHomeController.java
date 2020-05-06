package com.ps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {
	
	@RequestMapping("/welcome.htm")
	public String home() {
		return "home";
		
	}

}
