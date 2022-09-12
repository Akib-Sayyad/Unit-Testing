package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;

@SpringBootTest
class SpringBootMockitoApplicationTests {

	@Autowired
	UserService service;
	@MockBean
	private UserRepository repository;

	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new User(376, "test1", 31, "Pune"), new User(958, "test2", 35, "UK")).collect(Collectors.toList()));
		assertEquals(2, service.getUsers().size());
	}

	@Test
	public void getUserByAddressTest() {
		String address = "Pune";
		when(repository.findByAddress(address))
				.thenReturn(Stream.of(new User(376, "test1", 31, "Pune")).collect(Collectors.toList()));
		assertEquals(1, service.getUsersbyAddress(address).size());
	}

	@Test
	public void saveUserTest() {
		User user = new User(5, "test", 52, "UK");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}

	@Test
	public void daleteUserTest() {
		
		User user = new User(5, "test", 52, "UK");
		service.deleteUser(user);
		verify(repository, times(1)).delete(user);
	}
}
