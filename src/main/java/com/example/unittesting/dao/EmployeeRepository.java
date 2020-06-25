package com.example.unittesting.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unittesting.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
