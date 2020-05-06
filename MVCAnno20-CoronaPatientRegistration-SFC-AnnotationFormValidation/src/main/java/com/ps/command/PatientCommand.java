package com.ps.command;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientCommand {
	@NotEmpty(message = "[patient name is required(d)")
	private String patName;
	@NotEmpty(message = "patient address is required(d)")
	private String patAdd;
	@NotNull(message = "patient age is required(d)")
	@Range(min = 1,max = 100,message = "patient age must be 1 through 100(d)")
	private Integer age;	
	private String gender;
	private String stage;
	@NotEmpty(message = "hospital name is required(d)")
	@Length(min = 3,max = 15,message = "patient hospital name must have min of 3 chars and max 12 chars")
	private String hospital;
	private String vflag="no";
	
	public PatientCommand() {
		System.out.println("PatientCommand.PatientCommand()");
	}
	
}
