package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Data
public class Batch {

	@Column(nullable = false)
	@NotBlank(message = "Capacity should not be null")
	private int capacity;
	private String details;
	@Column(nullable = false)
	@NotBlank(message = "Start date should not be null")
	private String startDate;
	@Column(nullable = false)
	@NotBlank(message = "End date should not be null")
	private String endDate;
	
	
}
