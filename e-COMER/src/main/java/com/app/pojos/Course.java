package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode.Exclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course_tbl")
@Getter // for 
@Setter
@NoArgsConstructor // default constructor with no arguuments 
public class Course extends BaseEntity{
	@Column(length = 20, nullable = false) // nullable means value can not be null
	@NotBlank(message = "Couse name is must be added ")  // Not blank will throw an error if value is blank
	private String name;
	private String description;
//	@Column(nullable = false)
//	@NotBlank(message = "Fess should not be blank")
	private double fees;
	@Column(length = 20)
	private String duration;
	@Column(length = 20)
	private String selectionButton;
	
	// Course have the list of the subjects 
	@ElementCollection
	@CollectionTable(name = "subject_tbl", joinColumns = @JoinColumn(name = "course_id"))
	private List<Subject> subjects = new ArrayList<Subject>();
	
//	 course have the list of batches 
	@ElementCollection
	@CollectionTable(name = "batch_tbl", joinColumns = @JoinColumn(name = "course_id"))
   private List<Batch> batches = new ArrayList<Batch>();

	
	@JsonIgnore
	@OneToMany(mappedBy = "selectedCourse", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
	private List<User> users = new ArrayList<User>();
	
	// constructor 
	public Course(String name, String description, double fees, String duration) {
		super();
		this.name = name;
		this.description = description;
		this.fees = fees;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", description=" + description + ", fees=" + fees + ", duration=" + duration
				+ "]";
	}
	
	//add heplper methods
		public void addStudent(User user) {
			users.add(user);
			user.setSelectedCourse(this);
		}
		

}
