package com.ps.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCommand {
	private String userName;
	private String password;

	public UserCommand() {
		System.out.println("UserCommand:: 0-param constructor");
	}
}
