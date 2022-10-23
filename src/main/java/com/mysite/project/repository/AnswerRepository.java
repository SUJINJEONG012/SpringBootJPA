package com.mysite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mysite.project.model.Answer;


public interface AnswerRepository extends JpaRepository<Answer, Integer>{

}
