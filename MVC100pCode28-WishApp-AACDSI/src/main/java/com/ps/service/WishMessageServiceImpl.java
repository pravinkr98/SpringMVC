package com.ps.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageServiceImpl implements WishMessageService {
	
	public WishMessageServiceImpl() {
		System.out.println("WishMessageServiceImpl:: 0-param constructor");
	}

	@Override
	public String wishMessageGenerator() {
		System.out.println("WishMessageServiceImpl.wishMessageGenerator()");
		Calendar calendar=null;
		int hour=0;
		
		//get calendar object
		calendar=Calendar.getInstance();
		//get time
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		
		//write b.logic
		if(hour<12)
			return "Good Morning";
		else if(hour<16)
			return "Good Afternoon";
		else if(hour<20)
			return "Good Evening";
		else 
			return "Good Night";
	}

}
