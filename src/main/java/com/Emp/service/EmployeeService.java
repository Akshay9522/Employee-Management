package com.Emp.service;

import java.util.List;
import java.util.Optional;

import com.Emp.entity.Employee;


public interface EmployeeService {
	Employee save(Employee employee);
	List<Employee> empDetails();
	Optional<Employee> empSearch(String name);
	Employee getEmployeeByID(int id);
	int updateEmployee(Employee employee);
	String deleteEmpById(int id);   
	List<Employee> getAllEmployeeByPage(int page,int size);
}
