package com.ps.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserBO {
	private String userName;
	private String password;
	
	public UserBO() {
		System.out.println("UserBO:: 0-param constructor");
	}

}
