package com.ps.dao;

import java.util.List;

import com.ps.bo.EmployeeBO;
import com.ps.bo.EmployeeResultBO;

public interface EmployeeDAO {
	
	public List<EmployeeResultBO> searchEmployee(EmployeeBO bo);

}
