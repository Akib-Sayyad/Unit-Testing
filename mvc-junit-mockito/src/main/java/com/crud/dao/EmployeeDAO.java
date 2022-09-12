package com.crud.dao;

import java.util.List;

import com.crud.model.Employee;

public interface EmployeeDAO {
	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public void deleteEmployee(int employeeID);

	public Employee updateEmployee(Employee employee);

	public Employee getEmployee(int employeeID);

}
