package com.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.bo.EmployeeBO;
import com.ps.dao.EmployeeDAO;
import com.ps.dto.EmployeeDTO;

@Service
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	
	@Autowired
	EmployeeDAO dao=null;
		
	@Override
	public List<EmployeeDTO> fetchAllEmps() {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getAllEmps();
		//convert listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public EmployeeDTO fetchEmpByNo(int empno) {
		EmployeeDTO dto=null;
		EmployeeBO bo=null;
		//use DAO
		bo=dao.getEmpByNo(empno);
		//convert bo into dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		//return dto object
		return dto;
	}

	@Override
	public String doUpdateEmpByNo(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
		//convert dto object into bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		count=dao.updateEmpByNo(bo);
		return (count==0)?"Employee updation failed.":"Employee updation succeded.";
	}

	@Override
	public String doDeleteEmpByNo(int empno) {
		int count=0;
		//use dao
		count=dao.deleteEmpByNo(empno);
		return (count==0)?"Employee deletion failed.":"Employeee deletion succedded.";
	}

	@Override
	public String doInsertEmp(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
		//convert dto to bo object
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use DAO
		count=dao.insertEmp(bo);
		return (count==0)?"Employee registration failed.":"Employee registration succedded.";
	}

}
