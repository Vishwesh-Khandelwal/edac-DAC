package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEmpDao;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmpServiceImpl implements IEmpService {

	
	@Autowired 
	private IEmpDao edao;

	@Override
	public String hireEmp(Employee emp, String dept_name) {
		return edao.hireEmp(emp, dept_name);
	}
	
	
	
}
