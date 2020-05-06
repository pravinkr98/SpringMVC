package com.ps.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO implements Serializable {
	
	private int empno;
	private String ename;
	private String job;
	private float sal;

}
