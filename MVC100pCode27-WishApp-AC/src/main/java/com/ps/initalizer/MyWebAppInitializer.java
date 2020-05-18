package com.ps.initalizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.ps.config.RootAppConfig;
import com.ps.config.WebMvcAppConfig;

public class MyWebAppInitializer implements WebApplicationInitializer {
	
	public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer:: 0-param constructor");
	}

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		AnnotationConfigWebApplicationContext parentCtx=null,childCtx=null;
		ContextLoaderListener listener=null;
		DispatcherServlet ds=null;
		ServletRegistration.Dynamic dynamic=null;
		
		System.out.println("MyWebAppInitializer.onStartup()");
		
		//parent Container
		parentCtx=new AnnotationConfigWebApplicationContext();
		parentCtx.register(RootAppConfig.class);
		//create Listener
		listener=new ContextLoaderListener(parentCtx);
		//register ServletListener with ServletContainer
		sc.addListener(listener);
		
		//child Container
		childCtx=new AnnotationConfigWebApplicationContext();
		childCtx.register(WebMvcAppConfig.class);
		//create DispatcherServlet obj
		ds=new DispatcherServlet(childCtx);
		//register DispatcherServlet
		dynamic=sc.addServlet("dispatcher", ds);
		//set LoadOnStartup
		dynamic.setLoadOnStartup(2);
		dynamic.addMapping("*.htm");
		
		
	}

}
