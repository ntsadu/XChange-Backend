package com.xchange.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xchange.models.User;
import com.xchange.repositories.UserRepository;
	
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public User addUser(User user) {
		repo.save(user);
		return repo.findUserByUsername(user.getUsername());
	}
	
	@Override
	public List<User> findAllUsers() {
		return repo.findAll();
	}
	
	@Override
	public User findUserById(Long id) {
		return repo.getOne(id);
	}
	
	@Override
	public User findUserByUsername(String username) {
		return repo.findUserByUsername(username);
	}
	
	@Override
	public User findUserByEmail(String email) {
		return repo.findUserByEmail(email);
	}
	
	@Override
	public void updateUserById(Long userId, User u) {
		User user = repo.findOne(userId);
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());
		repo.save(user);
	}
	
	public User loginUser(User u) {
		return repo.findUserByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
	
}
