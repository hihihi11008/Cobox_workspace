package com.koreait.cobox.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/secure")
	public String adminMain(HttpServletRequest request) {
		
		return "admin/main";
	}
	
	
}
