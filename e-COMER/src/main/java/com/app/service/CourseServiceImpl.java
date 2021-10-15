package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.UserHandlingException;
import com.app.dao.CourseRepository;
import com.app.pojos.Batch;
import com.app.pojos.Course;
import com.app.pojos.CourseDetails;
import com.app.pojos.Subject;


@Service
@Transactional
public class CourseServiceImpl implements ICourseService{

	@Autowired
	private CourseRepository courseRepo;
	
	@Override
	public List<String> getName() {
		return courseRepo.getCourseName();
	}

	@Override
	public List<String> getDescription() {
		return courseRepo.getCourseDescription();
	}

	@Override
	public List<Double> getFees() {
		return courseRepo.getCourseFees();
	}

	@Override
	public List<String> getDuration() {
		return courseRepo.getCourseDuration();
	}

	@Override
	public List<Integer> getId() {
		return courseRepo.getCourseId();
	}

	@Override
	public Course getCourseDetails(int id) {
	    Course course =  courseRepo.findById(id).orElseThrow(() -> new UserHandlingException("Invalid Course id "));
		course.getBatches().size();
		course.getSubjects().size();
		course.getUsers().size();
		return course;
		
	}

	@Override
	public Course addNewCourse(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public Course updateCourse(Course course, Integer courseId) {
		// Updating the course 
	   Course updatedCourse = getCourseDetails(courseId);
	   updatedCourse.setName(course.getName());
	   updatedCourse.setDescription(course.getDescription());
	   updatedCourse.setFees(course.getFees());
	   updatedCourse.setDuration(course.getDuration());
       updatedCourse.setSubjects(course.getSubjects());
       updatedCourse.setBatches(course.getBatches());
	  
	  return updatedCourse;
	}

	@Override
	public String deleteCourse(Integer courseId) {
		Course course = getCourseDetails(courseId);
		courseRepo.delete(course);
		return "Course is deleted succesfully ";
	}

	
	@Override
	public String addSubject(com.app.pojos.Subject subject, Integer courseId) {
		Course course = getCourseDetails(courseId);
		course.getSubjects().add(subject);
		courseRepo.save(course);
		return "Course is added sucessfully";
	}

	// add the batch for the course 
	@Override
	public Course addBatch(Batch batch, Integer courseId) {
		Course course = getCourseDetails(courseId);
		course.getBatches().add(batch);
		return courseRepo.save(course);
	}

   // Retrieve the course details 
	@Override
	public List<Subject> getSubject(Integer courseId) {
		Course course = getCourseDetails(courseId);
		return course.getSubjects();
	}

	@Override
	public List<Batch> getBatch(Integer courseId) {
	     Course course = getCourseDetails(courseId);
		return course.getBatches();
	}
	
	
	
	
}
