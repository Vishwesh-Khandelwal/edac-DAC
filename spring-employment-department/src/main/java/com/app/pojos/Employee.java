package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="emp_tbl")
public class Employee extends BaseEntity {

	@Column(name="emp_name",length=30)
	private  String empName;
	@Column(length=30,unique=true)
	private  String email;
	private  double salary;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate DoB;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dept_id")// to specify name of the FK column
 
	private Department selectedDept;
	
	public Employee() {
		System.out.println("in emp cons");
	}

	public Employee(String empName, String email, double salary, LocalDate doB) {
		super();
		this.empName = empName;
		this.email = email;
		this.salary = salary;
		DoB = doB;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDoB() {
		return DoB;
	}

	public void setDoB(LocalDate doB) {
		DoB = doB;
	}

	
	public Department getSelectedDept() {
		return selectedDept;
	}

	public void setSelectedDept(Department selectedDept) {
		this.selectedDept = selectedDept;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", email=" + email + ", salary=" + salary + ", DoB=" + DoB + "]";
	}
	
	
}
