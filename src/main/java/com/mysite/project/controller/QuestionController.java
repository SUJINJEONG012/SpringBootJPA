package com.mysite.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.project.model.Question;

import com.mysite.project.service.QuestionService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/question")
@Controller
@RequiredArgsConstructor
public class QuestionController {
	
	@RequestMapping("/list")
	@ResponseBody
	public String list() {
		return "question list";
	}
	
}
