package com.ps.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ps.command.PersonCommand;

@Component
public class PersonCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("PersonCommandValidator.supports()");
		return clazz.isAssignableFrom(PersonCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("PersonCommandValidator.validate()");
		PersonCommand cmd=null;
		
		//type casting
		cmd=(PersonCommand)target;
		
		//Server side form validation
		if(cmd.getName()==null || cmd.getName().length()==0 || cmd.getName().equals(""))
			errors.rejectValue("name", "cmdPer.name.required");
		
		if(cmd.getAge()<1 || cmd.getAge()>100)
			errors.rejectValue("age", "cmdPer.age.range");
		
		if(cmd.getHobies()==null || cmd.getHobies().equals(""))
			errors.rejectValue("hobies", "cmdPer.hobies.required");

	}

}
