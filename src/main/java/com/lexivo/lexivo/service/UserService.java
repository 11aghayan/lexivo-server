package com.lexivo.lexivo.service;

import com.lexivo.lexivo.exception.UserNotFoundException;
import com.lexivo.lexivo.model.User;
import com.lexivo.lexivo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public void registerUser(User user) {
		userRepo.save(user);
	}

	public User getUserById(String id) throws UserNotFoundException {
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
}
