package com.ayty.fintech.Controller;

import java.util.List;

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
import com.ayty.fintech.Exception.UserAlreadyExistException;
import com.ayty.fintech.Service.UserService;
import com.ayty.fintech.Vo.UserVO;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;	
	
	public UserController(UserService userService) {
		super();
		this.userService= userService;
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserVO>> getAllUsers() {
		try {
			return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UserVO> getOneUser(@PathVariable(value = "id") long id){
		try {
			return new ResponseEntity<>(this.userService.getOneUser(id), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<UserVO> saveUser(@RequestBody @Validated User user) {
		try {
			return new ResponseEntity<UserVO> (this.userService.saveUser(user), HttpStatus.CREATED);
		} catch (UserAlreadyExistException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT); 
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") long id) {
		try {
			this.userService.deleteUser(id);
			return ResponseEntity.ok().build();
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<UserVO> updateUser(@PathVariable(value = "id")long id, @RequestBody @Validated User user) {
		try {
			return new ResponseEntity<>(this.userService.updateUser(id, user), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
}
