package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//parent class
@Entity //Mandatory
@Table(name="dept_tbl")
public class Department extends BaseEntity {
	//to specify field attribute in db using @ 

	@Column(name="dept_name",length=30)
	private String deptName;
	@Column(length=30)
	private String location;
	private int  strength;
	
	@OneToMany(mappedBy = "selectedDept", cascade=CascadeType.ALL,orphanRemoval=true)
	//value --- name of the property as it appears on the owning side.
	// fetch = FetchType.EAGER 
	//mappedBy : mandatory , MUST appear in inverse side,
		//CascadeType.ALL = Entity state transition should propagate from P->C
		//OrphanRemoval is entirely ORM specified thing.
		//It marks "child" to be removed from "parent" when it is no longer referenced  
	
	List<Employee> emps = new ArrayList<>();
	
	// default constructor
	public Department() {
			System.out.println("in dept cons");
	}

	//parameterized constructor
	public Department(String deptName, String location, int strength) {
		super();
		this.deptName = deptName;
		this.location = location;
		this.strength = strength;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	public void addEmployee(Employee emp) {
		emps.add(emp);
		emp.setSelectedDept(this);
	}

	
	@Override
	public String toString() {
		return "DepartmentId" +getId()+ " [deptName=" + deptName + ", location=" + location + ", strength=" + strength + "]";
	}
	
	
}
