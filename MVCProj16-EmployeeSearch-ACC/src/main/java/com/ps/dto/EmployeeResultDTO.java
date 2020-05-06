package com.ps.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeResultDTO extends EmployeeDTO {
	private int deptno;
	private int mgr;

}
