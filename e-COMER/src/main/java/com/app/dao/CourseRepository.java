package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;
import com.app.pojos.CourseDetails;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	@Query("select c.name from Course c")
	List<String> getCourseName();
	
	@Query("select c.description from Course c")
	List<String> getCourseDescription();
	
	@Query("select c.fees from Course c")
	List<Double> getCourseFees();
	
	@Query("select c.duration from Course c")
	List<String> getCourseDuration();
	
	@Query("select c.id from Course c")
	List<Integer> getCourseId();
	
	
}
