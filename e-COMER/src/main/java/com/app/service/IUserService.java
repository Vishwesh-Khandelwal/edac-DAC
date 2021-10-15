package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.ExamCenter;
import com.app.pojos.Examination;
import com.app.pojos.Qualification;
import com.app.pojos.User;
import com.app.pojos.UserImage;

public interface IUserService {

	User store(User user, int courseId ) throws IOException;
	
	String storeQualification(Qualification qualification , int userId );
	
	List<ExamCenter> fetchAllCenter();
	
	String storeExamDetails(Examination examDetails, int userId);
	
	// save the image 
	UserImage saveImage(MultipartFile file, int userId) throws IOException;

	String findByEmail(String email); 
}
