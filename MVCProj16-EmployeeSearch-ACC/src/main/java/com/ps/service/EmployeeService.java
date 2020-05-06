package com.ps.service;

import java.util.List;

import com.ps.dto.EmployeeDTO;
import com.ps.dto.EmployeeResultDTO;

public interface EmployeeService {
	
	public List<EmployeeResultDTO> search(EmployeeDTO dto);
}
