package com.mysite.project.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysite.project.DataNotFoundException;
import com.mysite.project.model.Question;
import com.mysite.project.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	//생성자로 주입
	private final QuestionRepository questionRepository;
	
	//질문 등록 
	public void create(String subject, String content) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	} 
	//질문 리스트 
	public List<Question> getList(){
		return this.questionRepository.findAll();
	}
	
	
	/*  
	 * 질문가져오기, 즉 상세보기
	 * 1.id 값으로 Question 데이터를 조회하는 getQuestion 메서드를 추가
	 * 2.리포지터리로 얻은 Question 객체는 Optional 객체이기 때문에 위와 같이 
	 * isPresent 메서드로 해당 데이터가 존재하는지 검사하는 로직이 필요하다
	 * 
	 * 3. 만약 id 값에 해당하는 Question 데이터가 없을 경우에는 
	 * DataNotFoundException을 발생시키도록 했다.
	 * */
	
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		
		//조건확인하고 예외처리 발생시킴
		if(question.isPresent()) {
			return question.get();
		}else {
			throw new DataNotFoundException("question not found,  아이디를 찾을 수 없습니다.");
		}
	}
	

	//페이징처리
	public Page<Question> getList(int page){
		//작성일시 역순으로 조회
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return this.questionRepository.findAll(pageable);
	}
	

}
