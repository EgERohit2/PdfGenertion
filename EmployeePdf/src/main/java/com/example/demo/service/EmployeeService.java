package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Employee;

public interface EmployeeService {

	public List<Employee> getAll();
	
	public Employee postAll(Employee employee);
	
	public void updateAll(Employee employee, int id);
	
	public void deleteAll(int id);
}
