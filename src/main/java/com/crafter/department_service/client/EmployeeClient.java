package com.crafter.department_service.client;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import com.crafter.department_service.model.Employee;

public interface EmployeeClient {

	@GetExchange(value="/employee/department/getEmployeeByDepartmentId/{departmentId}")
	public List<Employee> getEmployeeByDepartmentId(@PathVariable("departmentId") Long departmentId);
}
