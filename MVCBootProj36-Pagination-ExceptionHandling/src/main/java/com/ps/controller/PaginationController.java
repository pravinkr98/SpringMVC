package com.ps.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ps.command.PagingCommand;
import com.ps.dto.EmployeeDTO;
import com.ps.service.EmployeeMgmtService;

@Controller
public class PaginationController {
	
	@Autowired
	private EmployeeMgmtService service;

	@GetMapping("/page.htm")
	public String showHome(@ModelAttribute("pageCmd")PagingCommand cmd,HttpServletRequest req) {
		HttpSession ses=null;
		cmd.setPageSize(3);
		//get Acesss to session
		ses=req.getSession(true);
		ses.removeAttribute("pageSize");
		//return lvn
		return "page_form";
	}
	
	@RequestMapping("/report.htm")
	public String showReport(Map<String,Object> map,@ModelAttribute("pageCmd")PagingCommand cmd,HttpServletRequest req)throws Exception {
		int pageSize=0;
		HttpSession ses=null;
		int pageNo=0;
		int pagesCount=0;
		List<EmployeeDTO> listDTO=null;
		//get Session object
		ses=req.getSession(true);
		//get pageSize
		if(ses.getAttribute("pageSize")!=null)
			pageSize=(int)ses.getAttribute("pageSize");
		else {
			pageSize=cmd.getPageSize();
			ses.setAttribute("pageSize", pageSize);
		}
		//get PageNo.
		pageNo=Integer.parseInt(req.getParameter("pageNo"))-1;
		//pageNo=cmd.getPageNo()-1;
		//use service
		pagesCount=service.getPagesCount(pageSize);
		listDTO=service.getPageData(pageNo, pageSize);
		//keep result in model attribute
		map.put("pagesCount", pagesCount);
		map.put("listDTO", listDTO);
		//return lvn
		return "show_report";
	}
		
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView localExceptionHandler(NullPointerException ex) {
		return new ModelAndView("local_error","problem",ex.getMessage()+" \"NullPointerException()\"");
	}
	
	@ExceptionHandler(SQLGrammarException.class)
	public ModelAndView localExceptionHandler(SQLGrammarException ex) {
		return new ModelAndView("local_error","dbProblem",ex.getMessage()+" \"SQLGrammarException()\"");
	}
	
	/*@ExceptionHandler(Exception.class)
	public ModelAndView localExceptionHandler(Exception ex) {
		return new ModelAndView("local_error","exProblem",ex.getMessage()+" \"Exception()\"");
	}*/
	
}
