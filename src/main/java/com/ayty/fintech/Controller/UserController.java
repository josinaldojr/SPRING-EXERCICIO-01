package com.ayty.fintech.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayty.fintech.Entity.User;
import com.ayty.fintech.Exception.ResourceNotFoundException;
import com.ayty.fintech.Repository.UserRepository;
import com.ayty.fintech.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;	
	
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		
	}
	
	@Autowired
	UserService userService;	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable(value = "id") long id){
		try {
			return new ResponseEntity<>(this.userService.getOneUser(id), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody @Validated User user) {
		return new ResponseEntity<User> (userRepository.save(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") long id) {
		Optional<User> userFirst = userRepository.findById(id);
		if(!userFirst.isPresent()) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		} else {
			userRepository.delete(userFirst.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id")long id, @RequestBody @Validated User user) {
		Optional<User> userFirst = userRepository.findById(id);
		if(!userFirst.isPresent()) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		} else {
			user.setId(userFirst.get().getId());
			return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
		}
	}
	
}
