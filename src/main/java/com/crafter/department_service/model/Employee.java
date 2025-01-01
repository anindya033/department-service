package com.crafter.department_service.model;

public class Employee  {
	
	private Long id;
	private Long departmentId;
	private String name;
	private int age;
	private String position;
	
	
	
	public Employee(Long id, Long departmentId, String name, int age, String position) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.name = name;
		this.age = age;
		this.position = position;
	}
	public Long getId() {
		return id;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPosition() {
		return position;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}
	@Override
	
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (departmentId == null) {
			if (other.departmentId != null)
				return false;
		} else if (!departmentId.equals(other.departmentId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	
	
	
	
	
	
}
/*
 Long id, Long departmentId, String name, int age, String position
 
 */
