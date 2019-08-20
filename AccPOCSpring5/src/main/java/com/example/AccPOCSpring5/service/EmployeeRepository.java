package com.example.AccPOCSpring5.service;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.AccPOCSpring5.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

	@Query("{ 'name': ?0 }")
	Mono<Employee> findByName(final String name);
	
	Flux<Employee> findAll();
	
	Mono<Employee> insert(Employee employee);
	
	Flux<Employee> insert(List<Employee> employee);

}
