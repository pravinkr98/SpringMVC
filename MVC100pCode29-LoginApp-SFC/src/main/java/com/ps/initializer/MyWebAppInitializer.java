package com.ps.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ps.config.RootAppConfig;
import com.ps.config.WebMvcAppConfig;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public Class<?>[] getRootConfigClasses() {
		System.out.println("MyWebAppInitializer.getRootConfigClasses()");
		return new Class[] {RootAppConfig.class};
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		System.out.println("MyWebAppInitializer.getServletConfigClasses()");
		return new Class[] {WebMvcAppConfig.class};
	}

	@Override
	public String[] getServletMappings() {
		System.out.println("MyWebAppInitializer.getServletMappings()");
		return new String[] {"*.htm"};
	}

	

}
