package com.example.unittesting.service;

import java.util.List;
import com.example.unittesting.model.Employee;

public interface ServiceUnit {

	public List<Employee> findAll();
	
	public Employee findById(int id);
}
