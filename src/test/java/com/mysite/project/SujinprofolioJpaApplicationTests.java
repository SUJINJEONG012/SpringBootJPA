package com.mysite.project;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.project.model.Question;
import com.mysite.project.repository.QuestionRepository;


@SpringBootTest
class SujinprofolioJpaApplicationTests {
	
	 @Autowired
	 private QuestionRepository questionRepository;

	 @Test
	 void testJpa() {        
		 Question q = this.questionRepository.findBySubjectAndContent(
				 "sbb가 무엇인가요 ?", "sbb에 대해서 알고싶습니다."); 
		 assertEquals(1, q.getId());
	    }

}
