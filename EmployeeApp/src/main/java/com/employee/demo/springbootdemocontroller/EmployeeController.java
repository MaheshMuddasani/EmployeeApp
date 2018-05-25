package com.employee.demo.springbootdemocontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.demo.springbootdemomodel.Employee;
import com.employee.demo.springbootdemorepository.EmployeeRepository;

//it is the combination of spring controller and responsebody
//controller says to define controller and responsebody is to indicate return value of method should be used as r b of request
@RestController
@RequestMapping(value="/api")
public class EmployeeController {

@Autowired
EmployeeRepository repository;


//is a short form of requestmapping and requesttype is get
@GetMapping(value="/employee",  produces=MediaType.APPLICATION_JSON_VALUE)
public List<Employee> getAll() {
	List<Employee> list = new ArrayList();
	Iterable<Employee> employees = repository.findAll();

	employees.forEach(list::add);
	return list;
}

@PostMapping(value="/postemployee" ,consumes=MediaType.APPLICATION_JSON_VALUE)
public Employee postEmployee(@RequestBody Employee employee) {
//requestbody is to bind the request body with a method parameter
	repository.save(new Employee(employee.getFirstName(), employee.getLastName(),employee.getTimeOff(),employee.getTimeTable()));
	return employee;
}

@GetMapping(value="/findbylastname/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
public List<Employee> findByLastName(@PathVariable("lastName") String lastName) {

	List<Employee> employees = repository.findByLastName(lastName);
	return employees;
}


@GetMapping(value="/findbyId/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
public List<Employee> findbyId(@PathVariable("id") long id) {

	List<Employee> employees = repository.findById(id);
	return employees;
}


@DeleteMapping(value="/employee/{id}")
public void deleteEmployee(@PathVariable long id){
	
	repository.deleteById(id);
}
}
