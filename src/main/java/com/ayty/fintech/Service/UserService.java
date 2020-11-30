package com.ayty.fintech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayty.fintech.Entity.User;
import com.ayty.fintech.Exception.ResourceNotFoundException;
import com.ayty.fintech.Exception.UserAlreadyExistException;
import com.ayty.fintech.Repository.UserRepository;
import com.ayty.fintech.Vo.UserVO;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;	
		
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public List<UserVO> getAllUsers() throws ResourceNotFoundException {
		List<User> userList = userRepository.findAll();
		if(userList.isEmpty()) {
			throw new ResourceNotFoundException("Users not found");
		} else {
			return UserVO.createAllUsers(userList);
		}
	}
	
	public UserVO getOneUser(long id) throws ResourceNotFoundException {
		Optional<User> userFirst = userRepository.findById(id);
		if(!userFirst.isPresent()) {
			throw new ResourceNotFoundException("No user for this ID");
		} else {
			System.out.println(userFirst.toString());
			return UserVO.create(userFirst.get());
		}
	}
	
	public UserVO saveUser(User user) throws UserAlreadyExistException {
		Optional<User> userFirst = userRepository.findByCpf(user.getCPF());
		if(userFirst.isPresent()) {
			throw new UserAlreadyExistException("No user for this ID");
		} else {
			return UserVO.create(userRepository.save(user));
		}	
	}
	
	public void deleteUser(long id)  throws ResourceNotFoundException {
		Optional<User> userFirst = userRepository.findById(id);
		if(!userFirst.isPresent()) {
			throw new ResourceNotFoundException("No user for this ID");
		} else {
			userRepository.delete(userFirst.get());
		}
	}
	
	public UserVO updateUser(long id, User user) throws ResourceNotFoundException {
		Optional<User> userFirst = userRepository.findById(id);
		if(!userFirst.isPresent()) {
			throw new ResourceNotFoundException("No user for this ID");
		} else {
			user.setId(userFirst.get().getId());
			return UserVO.create(userRepository.save(user));
		}
	}
}
