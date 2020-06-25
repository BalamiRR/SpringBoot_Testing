package com.example.unittesting.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.unittesting.model.Employee;
import com.example.unittesting.service.ServiceUnit;

@RestController
public class ControllerUnit {
	
	private ServiceUnit serviceUnit;
	
	public ControllerUnit(ServiceUnit theServiceUnit) {
		serviceUnit = theServiceUnit;
	}
	
	@GetMapping("/list")
	public List<Employee> findAll() {
		return serviceUnit.findAll(); 
	}
	
	@GetMapping("list/{id}")
	public Employee findById(@PathVariable("id") int id) {
		return serviceUnit.findById(id);
	}

	
}