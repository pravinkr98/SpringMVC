package com.ps.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ps.dto.EmployeeDTO;
import com.ps.service.EmployeeMgmtService;

public class ListAllEmployeeController extends AbstractController {
	EmployeeMgmtService service=null;
	
	public ListAllEmployeeController(EmployeeMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		List<EmployeeDTO> listDTO=null;
		listDTO=service.fetchAllEmps();
		
		return new ModelAndView("show_emps","listDTO",listDTO);
	}

}
