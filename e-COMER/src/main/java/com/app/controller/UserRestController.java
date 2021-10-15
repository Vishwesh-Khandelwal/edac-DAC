package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ResponseMessage;
import com.app.pojos.Examination;
import com.app.pojos.Qualification;
import com.app.pojos.User;
import com.app.service.UserServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/courses/{id}/user")
public class UserRestController {

	@Autowired
	private UserServiceImpl userService;
	
	// for registering the user -> basic things
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody User user, @PathVariable int id)  {
		System.out.println("in save user "+ id);
		return new ResponseEntity<>(userService.store(user,id),HttpStatus.CREATED);	
	}
	
	// saving users qualification
	@PostMapping("/register/{userId}")
	public ResponseEntity<?> saveUserQualification(@RequestBody Qualification qualification,@PathVariable int userId){
		System.out.println("In save user qualification");
		return new ResponseEntity<>(userService.storeQualification(qualification, userId),HttpStatus.CREATED);
	}
	
	// Saving usesrs exam location and time details 
	@PostMapping("/register/{userId}/exam")
	public ResponseEntity<?> saveExamDetails(@RequestBody Examination examDetails, @PathVariable int userId){
		System.out.println("In save user saveExamDetails controller");
		return new ResponseEntity<>(userService.storeExamDetails(examDetails, userId),HttpStatus.CREATED);
	}
	
	// saving the users image 
	@PostMapping("/register/{userId}/exam/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable int userId){
		String message = "";
		try {
			userService.saveImage(file,userId);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			
		}catch(Exception e) {
			message = " could not upload the file "+ file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
}
