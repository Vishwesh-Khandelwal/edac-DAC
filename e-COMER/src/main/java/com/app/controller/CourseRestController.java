package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.pojos.CourseDetails;
import com.app.service.ICourseService;

@RestController // Restcontroller is used for controller + @Response body ---> Converts java object to json
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/courses")
public class CourseRestController {

	@Autowired
	private ICourseService courseService;
	
	public CourseRestController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	

	@GetMapping
	public List<CourseDetails>  getAllCourse(){
		System.out.println("In get all course");
		List<Integer>  id = courseService.getId();
		List<String>  name = courseService.getName();
		List<String> desc = courseService.getDescription();
		List<String> duration = courseService.getDuration();
		List<Double> fees = courseService.getFees();
		List<CourseDetails> details = new ArrayList<>();
	    for(int i=0 ; i<name.size() ; i++) {
	    	 details.add(new CourseDetails(id.get(i),name.get(i),desc.get(i),duration.get(i),fees.get(i)));
	    }
		return details;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCourseDetails(@PathVariable int id){
		System.out.println("in get course details " + id);
		return ResponseEntity.ok(courseService.getCourseDetails(id));
	}
}
