package com.ps.processor;

import org.springframework.batch.item.ItemProcessor;

public class CustomBookProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("CustomBookProcessor.process(-)");
		if(item.equalsIgnoreCase("Complete Reference Java"))
			return item+" ... by Herbert Schildt";
		else if(item.equalsIgnoreCase("Head First Java"))
			return item+" ... by Bert Bates and Kathy Sierra";
		else if(item.equalsIgnoreCase("BBJ"))
			return item+" ... by RNR";
		else if(item.equalsIgnoreCase("Thinking in Java"))
			return item+" ... by Bruce Eckel";
		else if(item.equalsIgnoreCase("Effective Java"))
			return item+" ... by Joshua Bloch";
		else
			return null;
	}

}
