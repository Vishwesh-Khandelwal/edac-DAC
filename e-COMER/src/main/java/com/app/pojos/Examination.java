package com.app.pojos;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "examination_tbl")
public class Examination extends BaseEntity{

	@Column(length = 20)
	private String examDate;
    
	@Column(length = 20)
	private String startTime;
	
	@Column(length = 20)
	private String endTime;
	@Column(length = 20,nullable = false)
	@NotBlank
	private String city;
	@Column(nullable = false)
	@NotBlank(message = "City can not be null")
	private String address;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	@MapsId   // sharing the same primary key of user 
	private User applicant;
}
