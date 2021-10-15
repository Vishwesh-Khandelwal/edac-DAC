package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer>{

       Optional<UserLogin> findByEmailIdAndPassword(String email, String pass);
	
}
