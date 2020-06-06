package com.ps.service;

import java.util.List;

import com.ps.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	public int getPagesCount(int pageSize);
	public List<EmployeeDTO> getPageData(int pageNo,int pageSize);
}
