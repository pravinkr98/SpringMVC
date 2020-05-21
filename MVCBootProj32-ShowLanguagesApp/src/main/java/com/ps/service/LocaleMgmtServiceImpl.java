package com.ps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service("langService")
public class LocaleMgmtServiceImpl implements LocaleMgmtService {

	@Override
	public List<String> fetchAllLanguages() {
		Locale locales[]=null;
		List<String> langList=null;
		//get all locales
		locales=Locale.getAvailableLocales();
		//Keep locale languages in list object
		langList=new ArrayList();
		for(Locale l:locales){
			langList.add(l.getDisplayLanguage());
		}
		
		return langList;
	}

}
