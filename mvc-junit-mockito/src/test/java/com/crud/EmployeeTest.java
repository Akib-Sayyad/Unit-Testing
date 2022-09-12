package com.crud;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.crud.dao.EmployeeDAO;
import com.crud.model.Employee;
import com.crud.service.EmployeeServiceImp;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest {

	@InjectMocks // autowired + dao will inject auto.
	EmployeeServiceImp service;
	@Mock
	EmployeeDAO dao;

	@Test(expected = RuntimeException.class)
	public void getEmployeeTest() {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, "t1", "t1@gmail.com", "India", "11111111"));
		list.add(new Employee(2, "t2", "t2@gmail.com", "India", "22222222"));

		when(dao.getAllEmployee()).thenReturn(list);

		List<Employee> empList = service.getAllEmployee();
		assertEquals(1, empList.size());
		verify(dao, times(1)).getAllEmployee();
	}

	@Test
	//@Ignore
	public void getEmployeeByIdTest() {

		when(dao.getEmployee(1)).thenReturn(new Employee(1, "t1", "t1@gmail.com", "India", "11111111"));
		when(dao.getEmployee(0)).thenThrow(new RuntimeException("Not Allowed"));

		Employee emp = service.getEmployee(0);
		assertEquals("t1", emp.getName());
		assertEquals("t1@gmail.com", emp.getEmail());
		assertEquals("India", emp.getAddress());
		assertThat("Emp", is("Emp"));
	}

	@Test
	public void addEmployeeTest() {
		Employee emp = new Employee(1, "t3", "t3@gmail.com", "India", "3333333");

		service.addEmployee(emp);

		verify(dao, times(1)).addEmployee(emp);
	}
}
