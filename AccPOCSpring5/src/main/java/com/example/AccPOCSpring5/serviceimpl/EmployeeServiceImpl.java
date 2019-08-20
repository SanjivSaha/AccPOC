package com.example.AccPOCSpring5.serviceimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.AccPOCSpring5.model.Employee;
import com.example.AccPOCSpring5.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    
	@Autowired
	MongoTemplate mongoTemplate;
	
	private static List<Employee> empList = null;
	static {
		empList=new ArrayList<Employee>();
		//empList.add(new Employee(1,"ABCD"));
		//empList.add(new Employee(2,"EFGH"));
	}

	@Override
	public Flux<Employee> getAllEmployees() {
		return  Flux.fromIterable(empList);
	}

	@Override
	public void saveAllEmployees(List<Employee> employee) {
		/*Mono<List<Employee>> fluxList=employee.collectList();
		List<Employee> monoList=fluxList.block();
		empList.addAll(monoList);*/
		for(Employee emp : employee) {
		   Employee empl = mongoTemplate.insert(emp);
		}
	}

	@Override
	public void saveEmployee(Employee employee) {
		/*List<Employee> monoList=(List<Employee>) employee.block();
		empList.addAll(monoList);*/
		Employee emp = mongoTemplate.insert(employee);
    }

	@Override
	public Mono<Employee> getEmployee(Integer id) {
		Employee employee = empList.stream()
				  .filter(emp -> id.equals(emp.getId()))
				  .findAny()
				  .orElse(null);
		return Mono.just(employee);
	}
}
