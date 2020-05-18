package com.ps.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="USER_INFO")
public class UserBO {
	@Id
	@Column(name="USERNAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String password;
	
	public UserBO() {
		System.out.println("UserBO:: 0-param constructor");
	}

}
