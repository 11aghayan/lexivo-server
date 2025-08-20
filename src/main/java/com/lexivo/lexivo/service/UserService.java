package com.lexivo.lexivo.service;

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
}
