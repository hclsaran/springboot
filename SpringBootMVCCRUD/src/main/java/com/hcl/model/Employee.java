package com.hcl.model;


import javax.persistence.*;

import lombok.*;

 
@Entity
@Table(name="db")
public class Employee {
	   @Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	@Id //@GeneratedValue(strategy=GenerationType.IDENTITY)
	   private long id;
	   private String name;
	public Employee() {}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee(long id,String name) {
		this.id=id;this.name=name;
	}
	  
	
	

}
