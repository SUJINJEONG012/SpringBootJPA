package com.mysite.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.project.model.Question;
import com.mysite.project.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {
	
	//생성자 주입
	private final QuestionService questionService;
	
	//질문 등록하기
	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) {
		return "question/question_form";
	}
	
	//질문등록 POST 요청을 처리할 수 있도록 다음처럼 컨트롤러를 수정
	
	@PostMapping("/create")
	
	/*
	 * @Valid 애너테이션을 적용하면 QuestionForm의 @NotEmpty, @Size 등으로 설정한 검증 기능이 동작한다.
	 * */
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question/question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
	
	
	
	//질문 리스트보기
	@GetMapping("/list")
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
		return "question/question_list";
	}
	
	/* 질문 상세보기
	 * 
	 * detail 메서드에서 Model 객체에 "question" 이라는 이름으로 Question 객체를 저장
	 * */
	
	
	@RequestMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		
		return "question/question_detail";
	}
	
	
	
}
