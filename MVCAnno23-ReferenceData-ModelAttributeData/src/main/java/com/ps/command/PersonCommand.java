package com.ps.command;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PersonCommand {
	private String name;
	private int age;
	private String gender="female";
	private String hobies[]= {"meditation","travelling"};
	private String qlfy="MCA";
	private String courses[]= {"java","oracle"};
	private Date dob,doj,dom;

}
