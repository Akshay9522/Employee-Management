package com.Emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Emp.entity.Employee;


public interface EmpRepository extends JpaRepository<Employee, Integer>{
	Employee findByFname(String fname);
	@Query(value="select * from employee_details where fname=:fname and lname=:lname",nativeQuery=true)
	public List<Employee> getData(@Param(value = "lname") String name ,@Param(value = "lname") String lname);
}
