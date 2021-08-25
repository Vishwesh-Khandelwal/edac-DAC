package com.app.pojos;

import javax.persistence.*;

@MappedSuperclass //to tell hibernate : no associated table BUT will be used as common super class for all
//other entities
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//default constructor
	public BaseEntity() {
		System.out.println("in base entity ctor");
	}
	//getter
	public Integer getId() {
		return id;
	}

	//setter
	public void setId(Integer id) {
		this.id = id;
	}

}
