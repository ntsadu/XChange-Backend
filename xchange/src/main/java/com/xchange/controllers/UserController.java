package com.xchange.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xchange.models.Company;
import com.xchange.models.User;
import com.xchange.services.UserService;

@CrossOrigin
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
	public void updateUser(@RequestBody User updatedUser) {
		System.out.println("[LOG] - In /UpdateUser");
		service.updateUserById(updatedUser.getUserId(), updatedUser);
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
	@RequestMapping(value="/GetUserByUsername", method=RequestMethod.POST)
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
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public User loginUser(@RequestBody User user) {
		return service.loginUser(user);
    }
	
	@RequestMapping(value="/AddUserSubscription", method=RequestMethod.POST)
	public Set<User> addUserSubscription(@RequestBody User[] users) {
		System.out.println("[LOG] - In /AddUserSubscription");
		return service.addUserSubscription(users[0].getUserId(), users[1].getUserId());
	}
	
	@RequestMapping(value="/AddUserFavorite", method=RequestMethod.POST)
	public Set<Company> addUserFavorite(@RequestBody User user, @RequestBody Company company) {
		System.out.println("[LOG] - In /AddUserFavorite");
		return service.addUserFavorite(user.getUserId(), company.getCompanyId());
	}
	
	@RequestMapping(value="/GetAllUserSubscriptions", method=RequestMethod.POST)
	public Set<User> getAllUserSubscriptions(@RequestBody User user) {
		System.out.println("[LOG] - In /GetAllUserSubscription");
		return service.findAllUserSubscriptions(user.getUserId());
	}
	
	@RequestMapping(value="/GetAllUserFavorites", method=RequestMethod.POST)
	public Set<Company> getAllUserFavorites(@RequestBody User user) {
		System.out.println("[LOG] - In /GetAllUserFavorites");
		return service.findAllUserFavorites(user.getUserId());
	}
	
	@RequestMapping(value="/RemoveUserSubscription", method=RequestMethod.POST)
	public void removeUserSubscription(@RequestBody User[] users) {
		System.out.println("[LOG] - In /RemoveUserSubscription");
		service.removeUserSubscription(users[0].getUserId(), users[1].getUserId());
	}
	
	@RequestMapping(value="/RemoveUserFavorite", method=RequestMethod.POST)
	public void removeUserFavorite(@RequestBody User[] users) {
		System.out.println("[LOG] - In /RemoveUserFavorite");
		service.removeUserFavorite(users[0].getUserId(), users[1].getUserId());
	}
		
}
