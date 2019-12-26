package com.ligne.bleue.uphf.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ligne.bleue.uphf.exeptions.EmptyFieldsException;
import com.ligne.bleue.uphf.exeptions.UserNotFoundException;
import com.ligne.bleue.uphf.models.User;
import com.ligne.bleue.uphf.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * Get a user by ID
	 **/
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id) {
		try {
			User user = userService.getUser(id);
			return ResponseEntity.ok().body(user);
		} catch (Exception e) {
			throw new UserNotFoundException(id);
		}
	}

	/**
	 * Get all users
	 **/
	@GetMapping("/all")
	public List<User> getAllUsers() {
		if (userService.getAllUsers().isEmpty()) {
			throw new UserNotFoundException();
		} else {
			return userService.getAllUsers();
		}
	}

	/**
	 * Create a new user
	 **/
	@PostMapping("/save")
	public User createUser(@RequestBody User user) {
		if (user.getEmail() == null || user.getFirstName() == null || user.getHeight() == 0
				|| user.getLastName() == null || user.getPassword() == null || user.getPhoneNumber() == null
				|| user.getRoles().isEmpty() || user.getTypeUser() == null || user.getWeight() == 0) {
			throw new EmptyFieldsException();
		} else {
			return userService.saveUser(user);
		}
	}

	/**
	 * Update a user
	 **/
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @Valid @RequestBody User userDetails) {
		User user = null;
		try {
			user = userService.getUser(id);

			if (userDetails.getFirstName() != null) {
				user.setFirstName(userDetails.getFirstName());
			}
			if (userDetails.getLastName() != null) {
				user.setLastName(userDetails.getLastName());
			}
			if (userDetails.getTypeUser() != null) {
				user.setTypeUser(userDetails.getTypeUser());
			}
			if (userDetails.getEmail() != null) {
				user.setEmail(userDetails.getEmail());
			}
			if (userDetails.getPassword() != null) {
				user.setPassword(userDetails.getPassword());
			}
			if (userDetails.getWeight() != 0) {
				user.setWeight(userDetails.getWeight());
			}
			if (userDetails.getHeight() != 0) {
				user.setHeight(userDetails.getHeight());
			}
			if (userDetails.getPhoneNumber() != null) {
				user.setPhoneNumber(userDetails.getPhoneNumber());
			}
			if (!userDetails.getRoles().isEmpty()) {
				user.setRoles(userDetails.getRoles());
			}

			User updatedUser = userService.saveUser(user);
			return ResponseEntity.ok().body(updatedUser);
		} catch (Exception e) {
			if (user == null) {
				throw new UserNotFoundException(id);
			} else {
				throw new EmptyFieldsException();
			}
		}
	}
}
