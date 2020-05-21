package com.ps.service;

import java.util.List;

import com.ps.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	public List<EmployeeDTO> fetchAllEmps();
	public EmployeeDTO fetchEmpByNo(int empno);
	public String doUpdateEmpByNo(EmployeeDTO dto);
	public String doDeleteEmpByNo(int empno);
	public String doInsertEmp(EmployeeDTO dto);
}
