package com.ps.handler;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		Calendar cal=null;
		int hour=0;
		RequestDispatcher rd=null;
		System.out.println("TimeCheckInterceptor.preHandle()");
		//get system date and time
		cal=Calendar.getInstance();
		//get current hour of the day
		hour=cal.get(Calendar.HOUR_OF_DAY);
		//check the timing of the request
		if(hour<9||hour>=17) {
			rd=req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("TimeCheckInterceptor.afterCompletion()");
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("TimeCheckInterceptor.postHandle()");
		
	}

}
