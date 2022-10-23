package com.mysite.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping("/")
	@ResponseBody
	public String home() {
		
		System.out.println("index");
		return "여깅 ㅔ오신걸 환영하빈다.";	
	}
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/question/list";
	}
	
}
