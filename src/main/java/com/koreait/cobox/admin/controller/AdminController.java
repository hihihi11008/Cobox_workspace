package com.koreait.cobox.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/secure")
	public String adminMain() {
		
		return "admin/main";
	}
	
	
}