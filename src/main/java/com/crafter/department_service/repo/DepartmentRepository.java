package com.crafter.department_service.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.crafter.department_service.model.Department;

@Repository
public class DepartmentRepository {
	
	private List<Department> departments = new ArrayList<>();
	
	public Department addDepartment(Department department) {
		departments.add(department);
		return department;
	}
	
	public Department findById(Long id) {
		 
		return departments.stream().filter(data-> data.getId().equals( id))
				.findFirst()
				.orElseThrow();
	}
	
	public List<Department> findAllDepartments(){
		return departments;
	}

}
