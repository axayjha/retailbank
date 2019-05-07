package com.design.interestcalc.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.design.interestcalc.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findByEmpIdAndPassword(Long empId,String password);
	Employee findByEmpId(Long empId);

	ArrayList<Employee> findAll();

}
