package com.saran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saran.ResourceNotFoundException;
import com.saran.dao.UserRepository;
import com.saran.model.User;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repo;

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return repo.save(user);
	}

	@GetMapping
	public List<User> listUser() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public User getOne(@PathVariable int id) {
		return repo.findById(id).get();
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable(value = "id") Integer userId, @RequestBody User userDetails) {

		User user = repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setUsername(userDetails.getUsername());
		user.setAge(userDetails.getAge());
		user.setSalary(userDetails.getSalary());
		
		User updatedUser = repo.save(user);
		return updatedUser;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		repo.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
