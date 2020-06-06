package com.ps.model;

import java.sql.Date;

import lombok.Data;

@Data
public class OExamResult {
	private int id;
	private int semester;
	private Date dob;
	private float percentage;
}
