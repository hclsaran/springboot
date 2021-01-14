package com.hcl.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.dao.EmpRepostiory;
import com.hcl.model.Employee;
import com.hcl.model.Employees;
@Controller
public class EmployeeController {
    @Autowired
    private EmpRepostiory repo;
    @PostMapping("/addemp")
    public String newEmp(Employee emp) {
        repo.save(emp);
        return "redirect:/listemp";
    }
    @GetMapping("/listemp")
    public ModelAndView listEmp(Employee emp) {
        List<Employee> allemps = (List<Employee>) repo.findAll();
        return new ModelAndView("emps", "employees", allemps);
    }

	
	/*
	 * @GetMapping("/addemp") public ModelAndView addNewEmp() { Employee e1 = new
	 * Employee(); return new ModelAndView("newemp", "form", e1); } public String
	 * showform(Model m) { m.addAttribute("command", new Employee()); return
	 * "newemp"; }
	 */
    @GetMapping("/updateemp/{id}")
    public String updateEmp(@PathVariable long id, Model m) {
        Employee emp = repo.findById(id).get();
        m.addAttribute("command", emp);
        return "editform";
    }
    @GetMapping("/editemp/{id}")
    public ModelAndView editCustomerForm(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("editform");
        Employee emp = repo.findById(id).get();
        mav.addObject("editemp", emp);
        return mav;
    }
    @PostMapping("/editemp/{id}")
    public String editsaveEmp(@ModelAttribute("emp") Employee emp) {
        repo.save(emp);
        return ("redirect:/listemp");
    }
    @GetMapping("/deleteemp/{id}")
    public ModelAndView deleteEmp(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("deleteform");
        Employee emp = repo.findById(id).get();
        mav.addObject("deleteemp", emp);
        return mav;
    }
    @PostMapping("/deleteemp/delete")
    public String deletesEmp(@ModelAttribute Employee emp) {
        repo.delete(emp);
        return ("redirect:/listemp");
    }
    @GetMapping("/JUnit") @ResponseBody
	public Employee testEmpPage() {

		Employee emp = new Employee();
		emp.setId(10);
		emp.setName("emp1");	 

		return emp;
	}
    
    
    @GetMapping(path="/employees", produces = "application/json")
    public Employees getEmployees() 
    {
		Employees response = new Employees();
		ArrayList<Employee> list = new ArrayList<>();
		repo.findAll().forEach(e -> list.add(e));
		response.setEmployeeList(list);
        return response;
    }

}