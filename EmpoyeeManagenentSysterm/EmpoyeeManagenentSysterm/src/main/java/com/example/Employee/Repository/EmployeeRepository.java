package com.example.Employee.Repository;

 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Employee.Entity.Employee;



@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	
}