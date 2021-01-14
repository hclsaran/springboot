package com.hcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.dao.EmpRepostiory;
import com.hcl.model.Employee;
@Service
public class EmpService {

	private EmpRepostiory repo;
	
	public Employee addEmp(Employee emp) {
		return  repo.save(emp);
	}
	
	
	public List<Employee> listEmps() {
		List<Employee> list=(List<Employee>) repo.findAll();
		return  list;
	}
	
}
