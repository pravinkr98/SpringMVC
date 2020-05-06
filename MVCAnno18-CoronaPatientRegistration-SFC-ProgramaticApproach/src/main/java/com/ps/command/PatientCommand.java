package com.ps.command;

import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientCommand {
	private String patName;
	private String patAdd;
	private Integer age;
	private String gender;
	private String stage;
	private String hospital;
	
	public PatientCommand() {
		System.out.println("PatientCommand.PatientCommand()");
	}
	
}
