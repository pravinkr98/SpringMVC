package com.ps.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ps.command.PatientCommand;

@Component("patCmdValidator")
public class PatientCommandValidator implements Validator {

	@Override	/*To check wheather corrent command class is assigned or not*/
	public boolean supports(Class<?> clazz) {
		System.out.println("PatientCommandValidator.supports()");
		return clazz.isAssignableFrom(PatientCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PatientCommand patCmd=null;
		System.out.println("PatientCommandValidator.validate()");
		//type casting
		patCmd=(PatientCommand)target;
		
		//server side form validations.
		if(patCmd.getPatName()==null || patCmd.getPatName().equalsIgnoreCase("") || patCmd.getPatName().length()==0)
			errors.rejectValue("patName", "patient.name.required");
		
		if(patCmd.getPatAdd()==null || patCmd.getPatAdd().equalsIgnoreCase("") || patCmd.getPatAdd().length()==0)
			errors.rejectValue("patAdd", "patient.address.required");
		
		if(patCmd.getAge()==null)
			errors.rejectValue("age", "patient.age.required");
		else if(patCmd.getAge()<1 || patCmd.getAge()>100)
			errors.rejectValue("age", "patient.age.range");
				
		if(patCmd.getHospital()==null || patCmd.getHospital().equalsIgnoreCase("") || patCmd.getHospital().length()==0)
			errors.rejectValue("hospital", "patient.hospital.required");
		else if(patCmd.getHospital().length()<3 || patCmd.getHospital().length()>15)
			errors.rejectValue("hospital", "patient.hispital.length");

	}

}
