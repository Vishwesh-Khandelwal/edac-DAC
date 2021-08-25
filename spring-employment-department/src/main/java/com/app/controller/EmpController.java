package com.app.controller;

import java.time.LocalDate;
import java.time.Period;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Employee;
import com.app.services.IDeptService;
import com.app.services.IEmpService;

@Controller
@RequestMapping("/employee")
public class EmpController {

	
	@Autowired
	private IEmpService eService;
	@Autowired
	private IDeptService dService;
	
	@GetMapping("/hire")
	public String showHiring(Employee emp, @RequestParam String dept_name, HttpSession session) {
		session.setAttribute("deptName", dept_name);
		System.out.println("in show");// model --> view
		return "/employee/hire";
	}

		@PostMapping("/hire")
		public String processEmployee(Employee emp, HttpSession session,RedirectAttributes flashMap, Model map) {
			System.out.println("in employee process");
			String deptName = (String)session.getAttribute("deptName");
			System.out.println("helllo");
			if((emp.getSalary() >= 30000) && (emp.getSalary() <= 40000)) {
				int age = Period.between(emp.getDoB(), LocalDate.now()).getYears();
				if(age >= 25 && age <= 35) {
					eService.hireEmp(emp, deptName);
					System.out.println("123");
					session.setAttribute("dept_details", dService.getAllDeptDetails());
					System.out.println("345");
					return "redirect:/department/list";
				}else {
					map.addAttribute("msg", "Employee Age should be in within 25 to 35...!!!");
				}
			}else {
				map.addAttribute("msg", "Employee Salary should be in between 30k to 40k...!!!");
			}
			return "/employee/hire";
		}
	}
