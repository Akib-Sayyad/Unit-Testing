package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByAddress(String address);

}
/*
{
"name":"abcd",
"age":"50",
"address":"Pune"
} 
*/
 