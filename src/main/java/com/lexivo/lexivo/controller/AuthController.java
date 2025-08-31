package com.lexivo.lexivo.controller;

import com.lexivo.lexivo.model.User;
import com.lexivo.lexivo.service.UserService;
import com.lexivo.lexivo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UserService service;

	@PostMapping("/login")
	public String login(@RequestBody User user) {
//		TODO: handle at the end
		return "Login route reached";
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		try {
			service.registerUser(user);
			return ResponseUtil.responseCreated();
		}
		catch (RuntimeException e) {
			return
					e instanceof DataIntegrityViolationException ?
					ResponseUtil.responseDuplicateUsername() :
					ResponseUtil.responseServerError();
		}
	}
}
