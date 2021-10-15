package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment_tbl")
@Getter
@Setter
@NoArgsConstructor
public class Payment extends BaseEntity{

	@Column(nullable = false)
	@NotNull
	private double Amount;
	// for enumeration
	@Enumerated(EnumType.STRING)
	private PaymentType type;
    @DateTimeFormat(pattern = "dd/MM/yyyy-hh:mm:ss")
	private LocalDateTime dateTime;
	private boolean status;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	@MapsId   // sharing the same primary key of user 
	private User applicant;

	// constructor based on our requirement 
	public Payment(double amount, PaymentType type, LocalDateTime dateTime, boolean status, User applicant) {
		super();
		Amount = amount;
		this.type = type;
		this.dateTime = dateTime;
		this.status = status;
		this.applicant = applicant;
	}
	
	
	
	
	
}
