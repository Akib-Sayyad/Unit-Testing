package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@PostMapping(value = "/save")
	public User saveUser(@RequestBody User user) {
		return service.addUser(user);
	}
	@GetMapping("/getUsers")
	public List<User> findAllUsers() {
		return service.getUsers();
	}
	@GetMapping("/getUserByAddress/{address}")
	public List<User> fingUsersbyAddress(@PathVariable String address) {
		return service.getUsersbyAddress(address);
	}
	@DeleteMapping(value="/remove")
	public void removeUser(@RequestBody User user) {
		service.deleteUser(user);
	}
}
