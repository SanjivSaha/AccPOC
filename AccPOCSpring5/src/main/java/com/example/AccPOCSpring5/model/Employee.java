package com.example.AccPOCSpring5.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "testdb")
public class Employee {

	@Id
	private BigInteger _id;
	private Integer id;
	private String name;
	public Employee(BigInteger _id, Integer id, String name) {
		super();
		this._id = _id;
		this.id = id;
		this.name = name;
	}
	public BigInteger get_id() {
		return _id;
	}
	public void set_id(BigInteger _id) {
		this._id = _id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee() {
		super();
		
	}
	
	

}
