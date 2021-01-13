package com.saran;
import java.util.*;
import java.util.stream.Collectors;
public class App 
{
//Java 8   
 public static void main( String[] args )
    {
    	 List<Employee> list=new ArrayList<>();
    	  list.add(new Employee(111,"Altaf",25,"Male","IT",2012,3000));
    	  list.add(new Employee(112,"John",26,"Male","HR",2015,6000));
    	  list.add(new Employee(112,"Sharon",26,"FeMale","HR",2015,8000));
          
         list.add(new Employee(113,"Kevin",27,"Male","Mechanical",2019,7000));
    	  list.add(new Employee(114,"Diemi",27,"FeMale","Civil",2020,2000));
    	  list.add(new Employee(115,"Kush",28,"Male","CS",2012,9000));
    	  list.add(new Employee(116,"Sam",29,"Male","Aeronautics",2010,1000));
    	  list.add(new Employee(118,"Saran",54,"Male","Maintanence",2021,12000));
    	  list.add(new Employee(117,"Kaite",30,"FeMale","Maintanence",2021,33000));
    	 
        		 
    	
    	//How many male and female emps are there in this org?
    	  
    	int maleCount= list.stream().filter(e->e.getGender().equals("Male")).map(e->e).collect(Collectors.toList()).size();
    	 int femaleCount=list.size()-maleCount;
    	 System.out.println(maleCount);System.out.println(femaleCount);
     	  
    	 
    	 Map<String,Long> maleandfemale=list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
    	 System.out.println(maleandfemale);
    	 
    	 //Print all the department in this org?
    	 
    	 list.stream().map(Employee::getDepartment).forEach(System.out::println);
    	 //Print the average age of male and female emps?
    	 
    	 Map<String,Double> maleandfemaleavg=list.stream()
    			 .collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));
    	 System.out.println(maleandfemaleavg);
      // Print the highest paid employee of this org?
    	// list.stream().map()
    	    
    	Employee  highestpaidEmp=  list.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
    	System.out.println(highestpaidEmp);
    // Find the name of all employees who have joined after the year 2013
    //	  Map<List<Employee>,Integer> emps2013=list.stream().collect(Collectors.groupingBy(Employee::getName),Collectors.groupingBy(null))
         list.stream().filter(e->e.getYoj() >2013).map(Employee::getName).forEach(System.out::println);
    // Count the number of emps in each department
         
       Map<String,Long> deptcount=list.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
       System.out.println(deptcount);
    // Print the average salary of each department
       Map<String,Double> avgsalaryeachdept=list.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
       System.out.println(avgsalaryeachdept);
     
    
    }
    
    
}
