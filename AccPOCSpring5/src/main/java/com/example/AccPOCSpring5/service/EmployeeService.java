package com.example.AccPOCSpring5.service;

import java.util.List;

import com.example.AccPOCSpring5.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

	public Flux<Employee> getAllEmployees();
	public void saveAllEmployees(List<Employee> employee);
	public void saveEmployee(Employee employee);
	public Mono<Employee> getEmployee(Integer id);
	
	
}
