package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable // embeddable because it is a value type 
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor // it is a constructor with all the arguments of the class 
@ToString
public class Subject {

	@Column(length = 20)
	private String subjectName;
	private String details;
}
