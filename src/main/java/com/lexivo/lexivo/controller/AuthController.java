package com.lexivo.lexivo.controller;

import com.lexivo.lexivo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		System.out.println(user);
		return "Login route reached";
	}
}
