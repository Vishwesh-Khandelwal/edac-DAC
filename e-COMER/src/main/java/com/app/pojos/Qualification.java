package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Qualification {

	@Column(length = 50, nullable = false)
	@NotBlank(message = "Degree should not be empty ")
	private String degree;
	@Column(length = 50, nullable = false)
	@NotBlank(message = "Specification should not be empty ")
	private String specification;
	@Column(length = 50, nullable = false)
	@NotBlank(message = "Institute name should not be empty ")
	private String instituteName;
	@Column(length = 50, nullable = false)
	@NotBlank(message = "University name should not be empty ")
	private String university;
	@Column(nullable = false, length = 20)
	private String passedOut;
	@Column(nullable = false)
	@NotBlank(message = "percentage should not be empty ")
	private String percentage;
	
	
	
}
