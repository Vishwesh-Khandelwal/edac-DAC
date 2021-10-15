package com.app.dao;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Batch;
import com.app.pojos.Course;
import com.app.pojos.Subject;
import com.app.pojos.User;

@SpringBootTest
class UserDaoTests {

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private UserRepository userRepo;

	@Test
	void testAddCourse() {

		List<Course> course = Arrays.asList(
				new Course("e-DAC", "Takes you to the development world", 50000.00, "5 Months"),
				new Course("e-DESD", "Takes you to the embedded world", 60000.00, "6 Months"));
		courseRepo.saveAll(course);

	}

	@Test
	void linkSuject() {
		List<Subject> subs = Arrays.asList(new Subject());
		Course course = courseRepo.findById(1).get();
		course.setSubjects(subs);
		courseRepo.save(course);

	}

	@Test
	void testAddUser() {

		List<User> user = Arrays.asList(new User());
		userRepo.saveAll(user);

	}
	
}

//public Course(String name, String description, double fees, String duration) {
/*
 * this.firstName = firstName; this.middleName = middleName; this.lastName =
 * lastName; this.email = email; DOB = dOB; this.address = address;
 * this.mobileNo = mobileNo;
 * 
 */