package com.ayty.fintech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ayty.fintech.Entity.User;
import com.ayty.fintech.Exception.ResourceNotFoundException;
import com.ayty.fintech.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;	
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers() {
		List<User> userList = userRepository.findAll();
		if(userList.isEmpty()) {
			throw new ResourceNotFoundException("Users not found");
		} else {
			return userList;
		}
	}
	
	public User getOneUser(long id) {
		Optional<User> userFirst = userRepository.findById(id);
		if(!userFirst.isPresent()) {
			throw new ResourceNotFoundException("No user for this ID");
		} else {
			return userFirst.get();
		}
	}
}
