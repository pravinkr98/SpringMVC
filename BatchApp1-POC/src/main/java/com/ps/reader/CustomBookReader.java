package com.ps.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class CustomBookReader implements ItemReader<String> {	
	private List<String> books;
	private int index=0;
	
	public void setBooks(List<String> books) {
		System.out.println("CustomBookReader.setBooks(-)");
		this.books = books;
	}

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("CustomBookReader.read()");
		if(index!=5)
			return books.get(index++);
		else
			return null;
	}

}
