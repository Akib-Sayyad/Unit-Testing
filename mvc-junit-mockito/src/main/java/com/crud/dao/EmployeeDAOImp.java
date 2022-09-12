package com.crud.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.model.Employee;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	
	public List<Employee> getAllEmployee() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();

	}

	
	public void deleteEmployee(int employeeID) {
		Employee emp = (Employee) sessionFactory.getCurrentSession().load(Employee.class, employeeID);
		if (null != emp) {
			this.sessionFactory.getCurrentSession().delete(emp);
		}
	}

	
	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;

	}

	
	public Employee getEmployee(int employeeID) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, employeeID);

	}

}
