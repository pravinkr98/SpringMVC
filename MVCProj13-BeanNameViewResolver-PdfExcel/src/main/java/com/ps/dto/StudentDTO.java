package com.ps.dto;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDTO implements Serializable {
	private int sno;
	private String sname;
	private String sadd;
	private String course;
	private float avg;

}
