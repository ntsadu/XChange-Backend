package com.xchange.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xchange.models.User;
import com.xchange.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;

	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:10
	@RequestMapping(value="/AddNewUser", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public User addUser(@RequestBody User newUser) {
		System.out.println("[LOG] - In /AddNewUser");
		return service.addUser(newUser);
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:15
	@RequestMapping(value="/UpdateUser", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public User updateUser(@RequestBody User updatedUser) {
		System.out.println("[LOG] - In /UpdateUser");
		return service.updateUserById(updatedUser.getUserId(), updatedUser);
	}
	
	// [DEV] - Method tested using Postman by WS on 27DEC2017 16:30
	@RequestMapping(value="/GetAllUsers", method=RequestMethod.GET)
	public List<User> findAllUsers() {
		System.out.println("[LOG] - In /GetAllUsers");
		System.out.println(service.findAllUsers());
		return service.findAllUsers();
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:20
	@RequestMapping(value="/GetUserById", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public User findUserById(@RequestBody User user) {
		System.out.println("[LOG] - In /GetUserById");
		System.out.println(service.findUserById(user.getUserId()));
		return service.findUserById(user.getUserId());
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:30
	@RequestMapping("/GetUserByUsername")
	public User findUserByUsername(@RequestBody User user) {
		System.out.println("[LOG] - In /GetUserByUsername");
		return service.findUserByUsername(user.getUsername());
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:33
	@RequestMapping(value="/GetUserByEmail", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public User findUserByEmail(@RequestBody User user) {
		System.out.println("[LOG] - In /GetUserByEmail");
		return service.findUserByEmail(user.getEmail());
	}
	
}
