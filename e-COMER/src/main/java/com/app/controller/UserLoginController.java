package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDetails;
import com.app.pojos.UserLogin;
import com.app.service.IUserLoginService;

import lombok.Data;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserLoginController {

	@Autowired
	private IUserLoginService loginService;
	
	@PostMapping("/login")
	public UserLogin loginUser(@RequestBody LoginDetails user){
		return loginService.fetchUser(user.getEmailId(), user.getPassword());
	}
	
	@PostMapping("/register")
	public UserLogin registerUser(@RequestBody UserLogin user) {
		return loginService.registerUser(user);
	}
		
}
