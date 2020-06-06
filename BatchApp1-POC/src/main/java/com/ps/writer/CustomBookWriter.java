package com.ps.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class CustomBookWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("CustomBookWriter.write(-)");
		System.out.println(items);

	}

}
