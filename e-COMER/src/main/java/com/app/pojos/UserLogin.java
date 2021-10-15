package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_login")
public class UserLogin extends BaseEntity{


	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastName;
	@Column(unique = true, nullable = false)
	private String emailId;
	private String password;
	@Column(unique = true, nullable = false)
	private Long mobileNo;
	@Column(length = 20)
	private String role;
	
	// Constructor is given instead of AllargsConstructor . Because if any user is added 
	public UserLogin(String firstName, String lastName,
			@UniqueElements(message = "User is already present ") String emailId, String password,
			@UniqueElements(message = "User is already present ") Long mobileNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNo = mobileNo;
		role = "user";
	}
	
	

	
	
}
