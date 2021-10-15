package com.app.service;

import java.util.List;

import com.app.pojos.Batch;
import com.app.pojos.Course;
import com.app.pojos.Subject;

public interface ICourseService {
	// For getting all the course 
	List<String> getName();
	
	List<String> getDescription();
	
	List<Double> getFees();
	
	List<String> getDuration();
	
	List<Integer> getId();
	
	// For getting the particular course by id 
	Course getCourseDetails(int id);
	
	// add new course from the admin part 
	Course addNewCourse(Course course);
	
	//update the course 
	Course updateCourse(Course course,Integer courseId);
	
	//delete course 
	String deleteCourse(Integer courseId);
	
	
     // add subject 
	String addSubject(Subject subject, Integer courseId);
	
	// add batch 
	Course addBatch(Batch batch, Integer courseId);
	
	// retrieve subject
	List<Subject> getSubject(Integer courseId);

	// retrieve batch 
	List<Batch> getBatch(Integer courseId);
}
