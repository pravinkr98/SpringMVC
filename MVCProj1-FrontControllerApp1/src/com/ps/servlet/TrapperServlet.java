package com.ps.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ps.handler.CountriesHandler;
import com.ps.handler.Handler;
import com.ps.handler.LanguagesHandler;

public class TrapperServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path=null;
		Handler handler=null;
		String lvn=null;
		String target=null;
		RequestDispatcher rd=null;
		try {
			//Action Management(Delegating to Handler classes)
			path=req.getServletPath(); //gives lang.do or countries.do
			if(path.equalsIgnoreCase("/lang.do")) {
				handler=new LanguagesHandler();
			}
			else if(path.equalsIgnoreCase("/countries.do")) {
				handler=new CountriesHandler();
			}
			else
				throw new IllegalArgumentException("Invalid request url");
			//invoke handler method
			lvn=handler.handle(req, res);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		//perform view management(mapping lvn to physical jsp)
		try {
			if(lvn.equalsIgnoreCase("disp_languages"))
				target="show_languages.jsp";
			else if(lvn.equalsIgnoreCase("disp_countries"))
				target="show_countries.jsp";
			else
				throw new IllegalArgumentException("Invalid lvn");
			//forward to target page/result page
			rd=req.getRequestDispatcher(target);
			rd.forward(req, res);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	}//doGet
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	//you are working with Praveen Kumar.

}
