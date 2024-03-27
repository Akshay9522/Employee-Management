package com.Emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Emp.Exception.NoSuchEmployeeException;
import com.Emp.entity.Employee;
import com.Emp.entity.Search;
import com.Emp.service.EmployeeSeriveImpl;


@Controller
public class EmpController {
	@Autowired
	EmployeeSeriveImpl empservice;
	@Autowired
	Search search;

	@GetMapping("/")
public String home() {
	return "index";
}
	@PostMapping("/register")
	public String saveAll(@ModelAttribute  Employee employee) {
	empservice.save(employee);
	return "sucess";
	}
	@GetMapping("/empdtls")
	public List<Employee> empAll() {
		return empservice.empDetails();
	}
	@GetMapping("/info")
	public String info(Employee employee) {
		return "search";
	}
	@PutMapping("/update")
	public String updateEmp(Employee employee) {
		 int updateEmployee = empservice.updateEmployee(employee);
		 return String.format("Employee is the updated for id %d", updateEmployee);
		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		return empservice.deleteEmpById(id);
	}
	
	@PostMapping("/search")
	 public ModelAndView  search(@ModelAttribute Search search) {
		Optional<Employee> empSearch = empservice.empSearch(search.getSearch());
		ModelAndView model = new ModelAndView("details");
        model.addObject("employees",empSearch.get());
		return model ;
	}
	@GetMapping(path="/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Employee getEmpByID(@PathVariable int id) throws NoSuchEmployeeException {
		Employee employeeByID = empservice.getEmployeeByID(id);
		if(employeeByID!=null) 
			return employeeByID;
		else throw new NoSuchEmployeeException("No employee present for that id");
		}
}
