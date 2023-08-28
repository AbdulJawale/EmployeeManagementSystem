package com.example.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Service.EmployeeService;

@RestController
public class EmployeeContoller
{
	 @Autowired
	 private EmployeeService services;
	 
	 @GetMapping("/getall")
	 public Iterable<Employee>getEmployee()
	 {
		 return services.listAll();     
	 }

	 @PostMapping(value = "/save")
	 private long saveBook(@RequestBody Employee employee)
	 {  
		 services.saveOrUpdate(employee);
		 return  employee.getId();
	 }
	   
	
	 @RequestMapping("/employee/{id}")
	 private Employee getEmployee(@PathVariable(name = "id") int employeeid)
	 {  
	 return services.getEmployeeById(employeeid);
	 }  
	 
	    
	 @PutMapping("/edit/{id}")

	    private Employee update(@RequestBody Employee employee)
	    {  
		   services.saveOrUpdate(employee);
	       return employee;
	    }  

	 @DeleteMapping("/delete/{id}")  
	 private void deleteEmployee(@PathVariable("id") int id)
	 {  
		 services.delete(id);  
	 }  
	
	  
}