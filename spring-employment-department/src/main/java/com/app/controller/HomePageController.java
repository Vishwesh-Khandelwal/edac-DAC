package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	
	public HomePageController() {
			System.out.println("in hp cons");
	}
	
	//add a req handling method to forward the user to index page
	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("in hp");
		return "/index";
		//redirect - transfers  a http request to another page
		//Actual view name : /WEB-INF/views/index.jsp

	}
	
}
