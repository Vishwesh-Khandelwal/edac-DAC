package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;
import com.app.pojos.Employee;

@Repository
public class EmpDaoImpl implements IEmpDao {

	
	@Autowired EntityManager mgr;
	
	@Override public String hireEmp(Employee emp, String dept_name) {
		 Department dept=mgr.createQuery("select d from Department d where d.deptName=:nm",Department.class).setParameter("nm",dept_name).getSingleResult();
		 dept.addEmployee(emp);
		 dept.setStrength(dept.getStrength()+1);
		 return "Employee added";
		  }	
}
