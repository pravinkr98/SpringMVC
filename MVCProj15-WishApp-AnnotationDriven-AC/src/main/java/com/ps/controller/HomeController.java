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
	
	/*@RequestMapping("/wish.htm")
	public ModelAndView process() {
		
		String msg=service.generateWishMessage();
		return new ModelAndView("result","wMsg",msg);
	}*/
	
	/*@RequestMapping("/wish.htm")
	public String process(Model model) {
		String msg=null;
		//use service
		msg=service.generateWishMessage();
		model.addAttribute("wMsg",msg);
		return "result";
	}*/
	
	/*@RequestMapping("/wish.htm")
	public String process(Map<String,Object> map) {
		String msg=null;
		//use service
		msg=service.generateWishMessage();
		//put model data
		map.put("wMsg",msg);
		//return logical view name
		return "result";
	}*/
	
	/*@RequestMapping("/wish.htm")
	public Model process() {
		String msg=null;
		Model model=null;
		//use service
		msg=service.generateWishMessage();
		//put model data
		model=new ExtendedModelMap();
		model.addAttribute("wMsg",msg);
		//return logical view name
		return model;
	}*/
	
	/*@RequestMapping("/wish.htm")
	public ModelMap process() {
		String msg=null;
		ModelMap model=null;
		//use service
		msg=service.generateWishMessage();
		//put model data
		model=new ModelMap();
		model.addAttribute("wMsg",msg);
		//return logical view name
		return model;
	}*/
	
	@RequestMapping("/wish.htm")
	public Map<String,Object> process() {
		String msg=null;
		Map<String,Object> map=null;
		//use service
		msg=service.generateWishMessage();
		//put model data
		map=new HashMap();
		map.put("wMsg",msg);
		//return logical view name
		return map;
	}
}
