package com.ps.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguagesHandler implements Handler {

	@Override
	public String handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Locale[] locales=null;
		List<String> languagesList=null;
		//write b.logic to all get all Countries
		locales=Locale.getAvailableLocales();
		languagesList=new ArrayList();
		for(Locale l:locales) {
			languagesList.add(l.getDisplayLanguage());
		}
		//keep the result in request scope
		req.setAttribute("result", languagesList);
		//return lvn
		return "disp_languages";
	}

}
