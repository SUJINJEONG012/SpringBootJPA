package com.mysite.project.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Question {
	
	/*
	 *@GeneratedValue를 사용하면1씩 자동증가 
	 *strategy은 고유번호를 생성하는 옵션
	 *GenerationType.IDENTITY는 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가시킬 때 사용한다.
	 * 
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// 고유번호 id (기본키pk) 
	private Integer id;

	@Column(length = 200)
	// 제목, length는 컬럼의 길이
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	/* columnDefinition = "TEXT"은 
	 * "내용"처럼 글자 수를 제한할 수 없는 경우에 사용한다.
	 * */ 
	private String content;
	private LocalDateTime createDate;
	
	/*
	 * 하나의 질문에 답변이 여러개이므로 Question 엔티티에 추가할 답변의 속성은 
	 * List 형태로 구성해야 한다. 
	 * 
	 * 질문을 삭제하면 그에 달린 답변들도 모두 함께 삭제하기 위해서 
	 * @OneToMany의 속성으로 cascade = CascadeType.REMOVE를 사용했다.
	 * 
	 * */
	@OneToMany(mappedBy ="question", cascade= CascadeType.REMOVE)
	private List<Answer> answerList;
	
	
	
}
