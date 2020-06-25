package com.example.unittesting.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.unittesting.dao.EmployeeRepository;
import com.example.unittesting.model.Employee;

@Service
public class ServiceUnitImpl implements ServiceUnit{

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public ServiceUnitImpl(EmployeeRepository thEmployeeRepository) {
		employeeRepository = thEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> employeeOpt = employeeRepository.findById(id);
		
		Employee empl = null;
		
		if(employeeOpt.isPresent()) {
			empl = employeeOpt.get();
		}
		
		else {
			throw new RuntimeException("Did not find employee " + id);
		}
		
		
		return empl;
	}

}
