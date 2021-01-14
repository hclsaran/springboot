package com.hcl.dao;

import org.springframework.data.repository.CrudRepository;

import com.hcl.model.Employee;

public interface EmpRepostiory extends CrudRepository<Employee,Long>{
	
}

/*
 * Design Patterns: SOLID principles 1. Program to interface not to an
 * implementation 
 * 2. It favors Object Composition over Inheritance
 */