package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "exam_center")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExamCenter extends BaseEntity {

	@Column(length = 20,nullable = false)
	@NotBlank(message = "City can not be null")
	private String city;
	@Column(nullable = false)
	@NotBlank(message = "City can not be null")
	private String address;
	@NotBlank
	private int capacity;
	
	
}
