package com.mysite.project.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition ="TEXT")
	
	private String content;
	private LocalDateTime createDate;
	
	/*
	 * question 속성은 답변 엔티티에서 질문 엔티티를 참조하기 위해 추가
	 * 
	 * ManyToOne -> 답변은 하나의 질문에 여러개가 달릴 수 있는 구조
	 * 따라서 @ManyToOne은 N:1 관계
	 * 
	 * @ManyToOne 애너테이션을 설정하면 Answer 엔티티의 question 속성과 
	 * Question 엔티티가 서로 연결된다. 
	 * (실제 데이터베이스에서는 ForeignKey 관계가 생성된다.)
	 * 
	 * @ManyToOne은 부모 자식 관계를 갖는 구조에서 사용한다. 
	 * 여기서 부모는 Question, 자식은 Answer라고 할 수 있다.
	 * 
	 * */
	@ManyToOne
	private Question question;

}
