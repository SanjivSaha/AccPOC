package com.example.AccPOCSpring5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AccPOCSpring5.model.Employee;
import com.example.AccPOCSpring5.service.EmployeeRepository;
import com.example.AccPOCSpring5.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

	 @Autowired
	 EmployeeService employeeService;
	 
	 @Autowired
	 EmployeeRepository employeeRepository;
	 
	 @GetMapping("/get/employee/all")
	 public Flux<Employee> getAllEmployee(){
		 return employeeRepository.findAll();
	 }
	 
	 @GetMapping("/get/employee/{id}")
	 public Mono<Employee> getEmployee(@PathVariable String name){
		 return employeeRepository.findById(name);
	 }
	 
	 @GetMapping(value="/get/employee/live", produces="text/event-stream")
	 public Flux<Employee> getAllEmployeeLive(){
		 return employeeRepository.findAll();
	 }
	 
	 @PostMapping(value="/save/employee/live", produces="application/stream+json")
	 public void saveAllEmployeeLive(@RequestBody List<Employee> employee){
		 employeeService.saveAllEmployees(employee);
	 }
	 
	 @PostMapping(value="/save/employee")
	 public void saveEmployee(@RequestBody Employee employee){
		 employeeService.saveEmployee(employee);
	 }
	
}
