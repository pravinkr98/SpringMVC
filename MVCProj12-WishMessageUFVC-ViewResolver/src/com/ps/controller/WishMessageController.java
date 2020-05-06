package com.ps.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishMessageController extends AbstractController {
	
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Date d=null;
		ModelAndView mav=null;
		String wish=null;
		Calendar calendar=null;
		int hour=0;
		
		d=new Date();
		calendar=Calendar.getInstance();
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		
		if(hour<12)
			wish="Good Morning";
		else if(hour<16)
			wish="Good AfterNoon";
		else if(hour<20)
			wish="Good Evening";
		else
			wish="Good Night";
		
		mav=new ModelAndView();
		mav.addObject("sysDate", d);
		mav.addObject("wsmg", wish);
		mav.setViewName("result");
		
		return mav;
	}
	

}
