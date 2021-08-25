package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;

@Repository
public class DeptDaoImpl implements IDeptDao {

	
	@Autowired EntityManager mgr;
	


@Override	
public List<Department> getAllDeptDetails() {
	String jpql = "select d from Department  d";
	return mgr.createQuery(jpql, Department.class).getResultList();
}

}
