package com.xchange.services;

import java.util.List;

import com.xchange.models.User;

public interface UserService {
	
	User addUser(User newUser);
	List<User> findAllUsers();
	User findUserById(Long id);
	User findUserByUsername(String username);
	User findUserByEmail(String email);
	User updateUserById(Long userId, User updatedUser);

}
