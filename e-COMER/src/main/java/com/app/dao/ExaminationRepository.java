package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Integer>{

}
