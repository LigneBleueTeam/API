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
		User user = userService.getUser(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(user);
		}
	}

	/**
	 * Get all users
	 **/
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	/**
	 * Create a new user
	 **/
	@PostMapping("/save")
	public User createUser(@Valid @RequestBody User user) {
		return userService.saveUser(user);
	}

	/**
	 * Update a user
	 **/
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @Valid @RequestBody User userDetails) {
		User user = userService.getUser(id);

		if (user == null) {
			return ResponseEntity.notFound().build();
		} else {
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
		}
	}

}
