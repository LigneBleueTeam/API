package com.ligne.bleue.uphf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligne.bleue.uphf.models.User;
import com.ligne.bleue.uphf.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	/**
	 * Get all users
	 * **/
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	/**
	 * Get a user by ID
	 * **/
	public User getUser(Long userID) {
		return userRepo.findById(userID).get();
	}
	
	/**
	 * Save a user
	 * **/
	public User saveUser(User user) {
		return userRepo.save(user);
	}
}
