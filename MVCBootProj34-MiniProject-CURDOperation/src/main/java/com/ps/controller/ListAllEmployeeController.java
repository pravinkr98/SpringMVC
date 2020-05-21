package com.ps.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.command.EmployeeCommand;
import com.ps.dto.EmployeeDTO;
import com.ps.service.EmployeeMgmtService;

@Controller
public class ListAllEmployeeController {
	
	@Autowired
	EmployeeMgmtService service;
	
	@RequestMapping("/welcome.htm")
	public String showHome() {
		return "welcome";
	}
	
	@RequestMapping("/listEmps.htm")
	public String ShowEmpList(Map<String,Object> map) {
		List<EmployeeDTO> listDTO=null;
		listDTO=service.fetchAllEmps();	
		//Keep data in map object
		map.put("listDTO", listDTO);
		return "show_emps";
	}
	
	@GetMapping("/update.htm")  //SFC-update form launching with formbacking object operations
	public String showEmpUpdateForm(@RequestParam("empno")int empNo,@ModelAttribute("empCmd")EmployeeCommand cmd) {
		EmployeeDTO dto=null;		
		//use service
		dto=service.fetchEmpByNo(empNo);
		//Keep dto object into cmd
		BeanUtils.copyProperties(dto, cmd);
		return "emp_update_form";
	}
	
	@PostMapping("/update.htm")		//SFC-update form launching with postbacking object operations
	public String EmpUpdateForm(Map<String,Object> map,@ModelAttribute("empCmd")EmployeeCommand cmd) {
		EmployeeDTO dto=null;
		List<EmployeeDTO> listDTO=null;
		String msg=null;
		//Keep dto object into command 
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		msg=service.doUpdateEmpByNo(dto);
		listDTO=service.fetchAllEmps();
		//Keep msg into map object
		map.put("resMsg", msg);
		map.put("listDTO", listDTO);
		return "show_emps";		
	}

	@RequestMapping("/delete.htm")
	public String deleteEmp(@RequestParam("empno")int empno,Map<String,Object> map) {
		List<EmployeeDTO> listDTO=null;
		String msg=null;
		//use Sevice
		msg=service.doDeleteEmpByNo(empno);
		listDTO=service.fetchAllEmps();	
		//Keep data in map object
		map.put("reMsg", msg);
		map.put("listDTO", listDTO);
		return "show_emps";
	}
	
	@PostMapping("/register.htm")  //SFC-insert form launching with postbacking object operations
	public String insertEmpForm(HttpSession ses,@ModelAttribute("empCmd")EmployeeCommand cmd) {
		EmployeeDTO dto=null;
		List<EmployeeDTO> listDTO=null;
		String msg=null;
		//convert cmd object into dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		msg=service.doInsertEmp(dto);
		listDTO=service.fetchAllEmps();
		//Keep message in map object
		//map.put("resMsg", msg);
		//map.put("listDTO", listDTO);
		ses.setAttribute("resMsg", msg);
		ses.setAttribute("listDTO", listDTO);
		return "redirect:/result.htm";
	}
	
	@GetMapping("/result.htm")
	public String showResultPage() {
		return "show_emps";
	}
	
	@GetMapping("/register.htm")	//SFC-insert form launching with formbacking object operations
	public String showInsertEmpForm(@ModelAttribute("empCmd")EmployeeCommand cmd) {
		return "emp_update_form";
	}
}
