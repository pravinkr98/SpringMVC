package com.ps.model;

import java.util.Date;

import lombok.Data;

@Data
public class ExamResult {

	private int id;
	private int sem;
	private Date dob;
	private double percentage;
}
