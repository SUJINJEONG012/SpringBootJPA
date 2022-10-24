package com.mysite.project.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mysite.project.model.Answer;
import com.mysite.project.model.Question;
import com.mysite.project.repository.AnswerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

	private final AnswerRepository answerRepository;


	/*
	 * 답변생성을위해 create메서드 생성
	 * 입력으로 받은 question content를 사용하여 Answer객체생성하여 저장 
	 * 
	 * 
	 * */
    public void create(Question question, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);
        
    }
    
}
