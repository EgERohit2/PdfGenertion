package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee postAll(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void updateAll(Employee employee, int id) {
		Employee employee2 = employeeRepository.findById(id).orElseThrow();
		employee2.setName(employee.getName());
		employee2.setEmail(employee.getEmail());
		employee2.setMobileNo(employee.getMobileNo());
		employeeRepository.save(employee2);
		
	}

	@Override
	public void deleteAll(int id) {
		employeeRepository.deleteById(id);
		
	}

}
