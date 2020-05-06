package com.ps.controller;

import java.net.BindException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ps.command.EmployeeCommand;
import com.ps.dto.EmployeeDTO;
import com.ps.dto.EmployeeResultDTO;
import com.ps.service.EmployeeService;

@Controller
public class EmployeeSearchController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/home.htm")
	public String handle() {
		return "input";
	}
	
	@RequestMapping("/search.htm")
	public String process(Map<String,Object> map,@ModelAttribute EmployeeCommand cmd,BindingResult br) {
		EmployeeDTO dto=null;
		List<EmployeeResultDTO> listRDTO=null;
		//convert command obj into dto obj
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service class
		listRDTO=service.search(dto);
		map.put("listRDTO", listRDTO);
		return "result";
	}

}
