package com.ps.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageServiceImpl implements WishMessageService {

	@Autowired
	private Calendar cal;
	
	@Override
	public String generateWishMessage() {
		int hour=0;
		//get time
		hour=cal.get(Calendar.HOUR_OF_DAY);
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
