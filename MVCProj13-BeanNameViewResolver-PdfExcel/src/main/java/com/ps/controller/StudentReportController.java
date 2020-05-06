package com.ps.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ps.dto.StudentDTO;

public class StudentReportController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		List<StudentDTO> listDTO=null;
		StudentDTO dto1=null,dto2=null,dto3=null;
		//create List Collection
		listDTO=new ArrayList();
		dto1=new StudentDTO();
		dto1.setSno(203);dto1.setSname("raja");dto1.setSadd("hyd");dto1.setCourse("java");dto1.setAvg(66.6f);
		dto2=new StudentDTO();
		dto2.setSno(204);dto2.setSname("vikash");dto2.setSadd("delhi");dto2.setCourse("oracle");dto2.setAvg(56.6f);
		dto3=new StudentDTO();
		dto3.setSno(205);dto3.setSname("vinod");dto3.setSadd("Aagra");dto3.setCourse("python");dto3.setAvg(76.6f);
		listDTO.add(dto1);listDTO.add(dto2);listDTO.add(dto3);
		//return MAV object
		if(req.getParameter("type").equalsIgnoreCase("excel"))
			return new ModelAndView("excelView", "listDTO", listDTO);
		else
			return new ModelAndView("pdfView", "listDTO", listDTO);

	}

}
