package com.app.service;

import com.app.pojos.UserLogin;

public interface IUserLoginService {
	
	// get user by email id and password 
	UserLogin fetchUser(String email, String pass);
	
	// register the given user 
	UserLogin registerUser(UserLogin user);

}
