package com.app.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.app.dao.CourseRepository;
import com.app.dao.ExamCenterRepository;
import com.app.dao.ExaminationRepository;
import com.app.dao.ImageHandlingRepository;
import com.app.dao.UserRepository;
import com.app.pojos.Course;
import com.app.pojos.ExamCenter;
import com.app.pojos.Examination;
import com.app.pojos.Qualification;
import com.app.pojos.User;
import com.app.pojos.UserImage;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	// for using user repository 
	@Autowired
	private UserRepository userRepo;
	
	// For using course repository 
	@Autowired
	private CourseRepository courseRepo;

	// for using exam center repository 
	@Autowired
	private ExamCenterRepository examRepo;
	
	// for saving examination details like exam time like that 
	@Autowired
	private ExaminationRepository examDetailsRepo;
	
	@Autowired
	private ImageHandlingRepository imageRepo;
	
	@Override
	public User store(User user,int courseId){
		System.out.println("in user store repostory");
		Course course = courseRepo.getById(courseId);
		course.getBatches().size();
		course.getSubjects().size();
		course.getUsers().size();
		course.addStudent(user);
	    return user;
	}

	@Override
	public String storeQualification(Qualification qualification, int userId) {

	   User user = userRepo.getById(userId);

//	   user.setQualifications(qualification);
	   user.getQualifications().add(qualification);
	   System.out.println("in adding qualification of service layer ");
		return "qualification is added successfully ";
	}

	@Override
	public List<ExamCenter> fetchAllCenter() {
		// TODO Auto-generated method stub
		return examRepo.findAll();
	}

	@Override
	public String storeExamDetails(Examination examDetails, int userId) {
		User user = userRepo.getById(userId);
		examDetails.setApplicant(user);
		 return "The details for the examination had been sent ";
	}

	@Override
	public UserImage saveImage(MultipartFile file, int userId) throws IOException {
		User user = userRepo.getById(userId);
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		UserImage imageFile  =  new UserImage(fileName, file.getContentType(), file.getBytes());
		imageFile.setOwner(user);
		return imageRepo.save(imageFile);
	}

	@Override
	public String findByEmail(String email) {
			User user=(User) userRepo.findByEmail(email);
			return "Sent Successfully";
			
	}

}
