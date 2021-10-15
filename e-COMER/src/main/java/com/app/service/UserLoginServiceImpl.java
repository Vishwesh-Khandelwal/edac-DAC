package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.UserHandlingException;
import com.app.dao.UserLoginRepository;
import com.app.pojos.UserLogin;

@Service
@Transactional
public class UserLoginServiceImpl implements IUserLoginService{
	
	@Autowired
	private UserLoginRepository userRepo;

	@Override
	public UserLogin fetchUser(String email, String pass) {
		UserLogin customer = userRepo.findByEmailIdAndPassword(email, pass)
				.orElseThrow(() -> new UserHandlingException("Auth Failed"));
		return customer;
				 }

	@Override
	public UserLogin registerUser(UserLogin user) {
		
		return userRepo.save(user);
	}

}
