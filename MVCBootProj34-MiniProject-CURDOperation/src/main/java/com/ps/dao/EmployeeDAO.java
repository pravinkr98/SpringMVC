package com.ps.dao;

import java.util.List;

import com.ps.bo.EmployeeBO;

public interface EmployeeDAO {
	public List<EmployeeBO> getAllEmps();
	public EmployeeBO getEmpByNo(int empno);
	public int updateEmpByNo(EmployeeBO bo);
	public int deleteEmpByNo(int empno);
	public int insertEmp(EmployeeBO bo);
	
}
