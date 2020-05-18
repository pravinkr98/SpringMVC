package com.ps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TileOperationTest {

	
	@RequestMapping("/welcome.htm")
	public String showHome() {
		return "homePageDef";
	}
	
	@RequestMapping("/courses.htm")
	public String showCourse() {
		return "coursePageDef";
	}
	
	@RequestMapping("/faculties.htm")
	public String showFaculty() {
		return "facultyPageDef";
	}
	
	@RequestMapping("/projects.htm")
	public String showProject() {
		return "projectPageDef";
	}
	
	@RequestMapping("/contacts.htm")
	public String showContact() {
		return "contactPageDef";
	}
}
