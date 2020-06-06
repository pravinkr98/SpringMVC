package com.ps.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ps.entity.Employee;

public interface EmployeeRepo extends PagingAndSortingRepository<Employee,Integer>{
		
}
