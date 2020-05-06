package com.ps.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ps.command.PersonCommand;
import com.ps.validation.PersonCommandValidator;

@Controller
public class PersonProfileController {
	
	@Autowired
	PersonCommandValidator validator;
	
	@InitBinder
	public void myBinder(ServletRequestDataBinder binder) {
		SimpleDateFormat sdf=null;
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
	}
	
	@ModelAttribute("gendersList")
	public List<String> populateGenders(){
		List<String> list=null;
		list=new ArrayList();
		list.add("male");list.add("female");
		return list;
	}
	
	@ModelAttribute("hobiesList")
	public List<String> populateHobies(){
		List<String> list=null;
		list=new ArrayList();
		list.add("meditation");list.add("travelling"); //here we can use from database also
		list.add("watchingTv");list.add("reading");
		list.add("workout");list.add("gaming");
		return list;
	}
	
	@ModelAttribute("coursesList")
	public List<String> populateCourses(){
		List<String> list=null;
		list=new ArrayList();
		list.add("java");list.add("oracle");	//here we can use from database also
		list.add("python");list.add(".net");
		list.add("jQuery");list.add("angularJs");
		list.add("UI");list.add("salesforce");
		return list;
	}
	
	@ModelAttribute("qlfyList")
	public List<String> populateQulification(){
		List<String> list=null;
		list=new ArrayList();
		list.add("B.E/B.Tech");list.add("BCA");		//here we can use from database also
		list.add("B.Sc");list.add("BA");
		list.add("MCA");list.add("MBA");
		list.add("M.Tech");
		return list;
	}
	
	@GetMapping("/register.htm")
	public String showForm(@ModelAttribute("perCmd") PersonCommand cmd) {
		return "person_register";
	}

	@PostMapping("/register.htm")
	public String processForm(Map<String,Object>map, @ModelAttribute("perCmd")PersonCommand cmd, BindingResult errors) {
		
		//perform validations
		if(validator.supports(cmd.getClass())) {
			validator.validate(cmd, errors);
			if(errors.hasErrors())
				return "person_register";
		}
		//return lvn
		map.put("cmdData", cmd);
		return "show_result";
	}
}
