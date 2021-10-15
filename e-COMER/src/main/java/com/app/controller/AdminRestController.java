
package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Batch;
import com.app.pojos.Course;
import com.app.pojos.Subject;
import com.app.service.ICourseService;

@RestController
@RequestMapping("/user/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminRestController {
	
	@Autowired
	private ICourseService courseService;
	
	//add course 
	@PostMapping("/add")
	public ResponseEntity<?> addNewCourse(@RequestBody Course course){
		return new ResponseEntity<>(courseService.addNewCourse(course),HttpStatus.CREATED);
	}
	
	// add subjects
	@PostMapping("/add_subjects/{courseId}")
	public ResponseEntity<?> addSubject(@RequestBody Subject subject, @PathVariable int courseId){
		return new ResponseEntity<>(courseService.addSubject(subject, courseId),HttpStatus.CREATED);
	}
	
	//return list of subjects 
	@GetMapping("/retrive_subject/{courseId}")
	public ResponseEntity<?> retrieveSubject(@PathVariable int courseId){
		return new ResponseEntity<>(courseService.getSubject(courseId),HttpStatus.CREATED);
	}
	
	//add batches 
	@PostMapping("/add_batches/{courseId}")
	public ResponseEntity<?> addBatch(@RequestBody Batch batch, @PathVariable int courseId){
		return new ResponseEntity<>(courseService.addBatch(batch, courseId),HttpStatus.CREATED);
	}
	
	// return list of batches 
	@GetMapping("/retrieve_batches/{courseId}")
	public ResponseEntity<?> retrieveBatch(@PathVariable int courseId){
		return new ResponseEntity<>(courseService.getBatch(courseId),HttpStatus.CREATED);
	}
	
	// update course 
	@PostMapping("/update/{courseId}")
	public ResponseEntity<?> updateCourse(@RequestBody Course course, @PathVariable int courseId){
		return new ResponseEntity<>(courseService.updateCourse(course,courseId), HttpStatus.CREATED);
	}
	
	// delete course 
	@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable int courseId){
		return new ResponseEntity<>(courseService.deleteCourse(courseId),HttpStatus.CREATED);
	}
	
	
}
