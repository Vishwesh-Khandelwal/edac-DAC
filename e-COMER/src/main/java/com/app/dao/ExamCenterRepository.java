package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.ExamCenter;

@Repository
public interface ExamCenterRepository extends JpaRepository<ExamCenter, Integer>{

}
