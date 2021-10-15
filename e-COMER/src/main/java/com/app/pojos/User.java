package com.app.pojos;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_tbl")
public class User extends BaseEntity{
	
	@Column(length = 20,nullable = false)
	@NotBlank(message = "first name is required")
	private String firstName;
	@Column(length = 20)
	private String middleName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 20,unique = true, nullable = false)
	private String email;
	private LocalDate DOB;
	
	private String address;
	@Column(unique = true, nullable = false)
	private String mobileNo;
	
	
	//User has the list of eduacational qualifications 
	@ElementCollection
	@CollectionTable(name = "education_qualification", joinColumns = @JoinColumn(name = "user_id"))
	private List<Qualification> qualifications = new ArrayList<Qualification>();
	
	//many to one --> many user will have one course 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "course_id")
	private Course selectedCourse;

	
	public User(@NotBlank(message = "first name is required") String firstName, String middleName,
			@NotBlank(message = "last name is required") String lastName,
			@UniqueElements(message = "email should be unique") String email,
			@NotBlank(message = "DOB is required") LocalDate dOB, String address,
			@UniqueElements(message = "mobile no should  be unique") String mobileNo) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		DOB = dOB;
		this.address = address;
		this.mobileNo = mobileNo;
		
		System.out.println("DOB is "+ DOB);
	}



}
