package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;
import com.app.pojos.UserLogin;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
		List<User> findByEmail(String email);
}
