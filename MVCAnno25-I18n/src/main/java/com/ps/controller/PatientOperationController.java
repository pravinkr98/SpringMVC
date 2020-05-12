package com.ps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ps.command.PatientCommand;

@Controller
public class PatientOperationController {
	
	@RequestMapping("/register.htm")
	public String showForm(@ModelAttribute("patCmd")PatientCommand cmd) {
		return "patient_register";
	}
}
