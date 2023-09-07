package com.amdocs.gradleSpring.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.amdocs.gradleSpring.Repository.*;
import com.amdocs.gradleSpring.exceptions.EmployeeNotFound;
import com.amdocs.gradleSpring.EmployeeModel.*;

@Service
public class EmployeeServiceImple {

	@Autowired
	EmployeeDbRepository empRepository;

	public List<Employee> findAll(Pageable pageable)
	{
		return empRepository.findAll(pageable).toList();
	}

	public Employee findById(int id) throws EmployeeNotFound 
	{
		Optional<Employee> emp = empRepository.findById(id);
		return emp.orElseThrow(()->new EmployeeNotFound("Employee not found: " + id));
	}

	public Employee addEmployee(Employee emp)
	{
		return empRepository.save(emp);
	}

	public Employee updateEmployee(int id,Employee emp) throws EmployeeNotFound 
	{
		Employee emp1 = findById(id);
		emp1.setName(emp.getName());
		emp1.setJobRole(emp.getJobRole());
		emp1.setBloodgroup(emp.getBloodgroup());
		empRepository.save(emp1);
		return emp1;
	}

	public void deleteEmployee(int id) throws EmployeeNotFound 
	{
		Employee emp = findById(id);
		empRepository.delete(emp);	
	}

}


