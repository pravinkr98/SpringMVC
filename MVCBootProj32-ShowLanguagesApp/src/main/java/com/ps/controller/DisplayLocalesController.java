package com.ps.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ps.service.LocaleMgmtService;

@Controller
public class DisplayLocalesController {
	
	@Autowired
	private LocaleMgmtService service;

	@RequestMapping("/welcome.htm")
	public String showHome() {
		return "show_home";
	}
	
	@RequestMapping("/lang.htm")
	public String showLanguages(Map<String,Object> map) {
		List<String> langList=null;
		//use Service
		langList=service.fetchAllLanguages();
		//Keep list object to map as model attribute
		map.put("langList", langList);
		//return lvn
		return "show_languages";
	}
	
	
}
