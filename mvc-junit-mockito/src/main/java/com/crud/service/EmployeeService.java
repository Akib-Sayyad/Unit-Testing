package com.crud.service;

import java.util.List;

import com.crud.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public void deleteEmployee(int employeeID);

	public Employee updateEmployee(Employee employee);

	public Employee getEmployee(int employeeID);

}
