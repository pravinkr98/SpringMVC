package com.ps.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(Exception.class)
	public ModelAndView localExceptionHandler(Exception ex) {
		return new ModelAndView("global_error","problem",ex.getMessage());
	}
}
