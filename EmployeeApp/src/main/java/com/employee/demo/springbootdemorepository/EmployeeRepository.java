package com.employee.demo.springbootdemorepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.employee.demo.springbootdemomodel.Employee;

 
 // employee type of interface and extends CRUD is to expose a complete set of methods to manipulate entities

public interface EmployeeRepository extends CrudRepository<Employee, Long>


 // query builder mechanism and which trips the prefixes..findBy, readBy, queryBy..from the method and starts parsing the rest 
{
	List<Employee> findByLastName(String lastName);
	List<Employee> findById(long id);
}