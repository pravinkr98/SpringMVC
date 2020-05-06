package com.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.bo.EmployeeBO;
import com.ps.bo.EmployeeResultBO;
import com.ps.dao.EmployeeDAO;
import com.ps.dto.EmployeeDTO;
import com.ps.dto.EmployeeResultDTO;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public List<EmployeeResultDTO> search(EmployeeDTO dto) {
		List<EmployeeResultDTO> listRDTO=new ArrayList<EmployeeResultDTO>();
		EmployeeBO bo=null;
		List<EmployeeResultBO> listRBO=null;
		//convert EmployeeDTO to EmployeeBO
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		listRBO=dao.searchEmployee(bo);
		//copy each listRBO to listRDTO
		listRBO.forEach(rbo->{
			EmployeeResultDTO dto1=new EmployeeResultDTO();
			//copy rbo to bo1
			BeanUtils.copyProperties(rbo, dto1);
			//add dto1 to listDTO
			listRDTO.add(dto1);
		});		
		return listRDTO;
	}

}
