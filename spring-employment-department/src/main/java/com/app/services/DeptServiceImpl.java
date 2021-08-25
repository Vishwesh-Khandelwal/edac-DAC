package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDeptDao;
import com.app.pojos.Department;

@Service
@Transactional
public class DeptServiceImpl implements IDeptService {

	
	@Autowired IDeptDao dDao;

	@Override
	public List<Department> getAllDeptDetails() {
		return dDao.getAllDeptDetails();
	}
	
}
