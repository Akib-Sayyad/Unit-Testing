package com.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.EmployeeDAO;
import com.crud.model.Employee;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDao;

	@Transactional
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Transactional
	public void deleteEmployee(int employeeID) {
		employeeDao.deleteEmployee(employeeID);
	}

	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	public Employee getEmployee(int employeeID) {
		return employeeDao.getEmployee(employeeID);
	}

	public void setEmployeeDao(EmployeeDAO employeeDAO) {
		this.employeeDao = employeeDAO;
	}
}
