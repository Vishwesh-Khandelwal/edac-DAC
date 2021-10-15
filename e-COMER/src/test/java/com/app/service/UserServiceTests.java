package com.app.service;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.ExamCenter;

@SpringBootTest
class UserServiceTests {
	@Autowired
	private IUserService  uService;

	@Test
	public void testFetchAllCenters() {

		List<ExamCenter> centers = uService.fetchAllCenter();
		assertEquals(3,centers.size());
	
	
	}

}
