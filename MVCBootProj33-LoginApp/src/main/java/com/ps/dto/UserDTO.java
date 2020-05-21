package com.ps.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO implements Serializable {
	private String userName;
	private String password;

	public UserDTO() {
		System.out.println("UserDTO:: 0-param constructor");
	}
}
