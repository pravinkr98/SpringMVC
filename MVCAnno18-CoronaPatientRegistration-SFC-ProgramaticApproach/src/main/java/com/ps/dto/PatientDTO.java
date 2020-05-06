package com.ps.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public final class PatientDTO implements Serializable {
	private String patName;
	private String patAdd;
	private int age;
	private String gender;
	private String stage;
	private String hospital;
}
