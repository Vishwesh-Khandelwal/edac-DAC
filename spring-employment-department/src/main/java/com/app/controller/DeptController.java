package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.services.IDeptService;

@Controller
@RequestMapping("/department")
public class DeptController {

	public DeptController() {

			System.out.println("in deptController");
	}
	
	@Autowired
	private IDeptService dService;
	
	@GetMapping("list")
	// Handler Mapping  : key : /user/login + method=get
	// value : UserController.showLoginForm
	public String showDeptList(HttpSession session) {
		System.out.println("in show dept list");
		// add branch_name as a model attribute, read from type enum values 
	
		session.setAttribute("dept_details",dService.getAllDeptDetails());
		return "/department/list";
		// Actual view name : /WEB-INF/views/user/login.jsp
	}

	
}


