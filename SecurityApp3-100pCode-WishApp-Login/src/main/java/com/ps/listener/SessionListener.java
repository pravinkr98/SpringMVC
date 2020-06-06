package com.ps.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent session) {
		System.out.println("====SessionListener.sessionCreated()");
		session.getSession().setMaxInactiveInterval(1*60); //(1 minute)
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionListener.sessionDestroyed()=====");
	}
}
