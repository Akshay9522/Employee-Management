package com.Emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.Emp.entity.Employee;
import com.Emp.repository.EmpRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class EmployeeSeriveImpl implements EmployeeService {
	@Autowired
	EmpRepository empResitory;

	@Override
	public Employee save(Employee employee) {
		return  empResitory.save(employee);
	}

	@Override
	public List<Employee> empDetails() {
		return empResitory.findAll(Sort.by("fname").ascending());	}

	@Override
	public Optional<Employee> empSearch(String name) {
		 
				Optional<Employee> byFname = Optional.of(empResitory.findByFname(name));
				return byFname;
	}

	@Override
	public Employee getEmployeeByID(int id) {
		Optional<Employee> optional = empResitory.findById(id);
		if (optional.isPresent()) 
			return optional.get();
		
		return null;
	}

	@Override
	public int updateEmployee(Employee employee) {
		Employee updateEmp = empResitory.save(employee);
		return updateEmp.getId();
	}

	@Override
	public String deleteEmpById(int id) {
		empResitory.deleteById(id);
		return "Employee Deleted";
	}

	@Override
	public List<Employee> getAllEmployeeByPage(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Employee> all = empResitory.findAll(pageRequest);
		List<Employee> content = all.getContent();
		return content;
	}
	
}
