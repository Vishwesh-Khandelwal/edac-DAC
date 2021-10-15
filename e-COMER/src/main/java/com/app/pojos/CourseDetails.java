package com.app.pojos;



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
public class CourseDetails {

	private int id;
	private String name;
	private String description;
	private String duration;
	private double fees;
	
}

//just for data transfer object 
//no entity no extends not in db