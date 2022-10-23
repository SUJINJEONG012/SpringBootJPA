package com.mysite.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.project.model.Question;

/*
 * JpaRepository 인터페이스를 상속
 * 제네릭스 타입으로 <Question, Integer> 처럼 리포지터리의 대상이 되는 엔티티의 타입(Question)과 해당 엔티티의 PK의 속성 타입(Integer)을 지정해야 한다. 
 * 이것은 JpaRepository를 생성하기 위한 규칙
 * */
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	Question findBySubject(String subject);

}
