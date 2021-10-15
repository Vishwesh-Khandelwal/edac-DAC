package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.ExamCenter;
import com.app.service.IUserService;

@RestController
@RequestMapping("/exam_center")
@CrossOrigin(origins = "http://localhost:3000/")

public class ExamCenterController {
	
	@Autowired
	private IUserService userService;


	@GetMapping
	public List<ExamCenter> getallExamCenter(){
		return userService.fetchAllCenter();
	}
}
