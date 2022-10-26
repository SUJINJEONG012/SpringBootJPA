package com.mysite.project.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.project.AnswerForm;
import com.mysite.project.model.Question;
import com.mysite.project.service.AnswerService;
import com.mysite.project.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

	private final QuestionService questionService;
	private final AnswerService answerService;
	
	//답변생성
	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id, 
		@Valid AnswerForm answerForm, BindingResult bindingResult) {
	
		Question question = this.questionService.getQuestion(id);
		
		//@Valid와 BindingResult를 사용하여 검증을 진행
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("question", question);
			return "question_detail";
		}
		
		//answerService에서 만든 메서드를 호출하여 답변을 저장
		this.answerService.create(question, answerForm.getContent());
		
		// %s는 문자열 
		return String.format("redirect:/question/detail/%s", id);
	}
}
