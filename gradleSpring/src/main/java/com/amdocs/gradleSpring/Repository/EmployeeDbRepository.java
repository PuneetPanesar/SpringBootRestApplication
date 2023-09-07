package com.amdocs.gradleSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amdocs.gradleSpring.EmployeeModel.Employee;

public interface EmployeeDbRepository extends JpaRepository<Employee,Integer>{
			
}
