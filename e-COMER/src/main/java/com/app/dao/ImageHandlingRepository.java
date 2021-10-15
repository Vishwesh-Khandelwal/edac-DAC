package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.UserImage;

public interface ImageHandlingRepository extends JpaRepository<UserImage, Integer>{

}
