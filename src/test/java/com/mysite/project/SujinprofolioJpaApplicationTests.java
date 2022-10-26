package com.mysite.project;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mysite.project.service.QuestionService;


@SpringBootTest
class SujinprofolioJpaApplicationTests {
	
	 @Autowired
	 private QuestionService questionService;
	
	 @Test
	 void testJpa() {
	        
		 for(int i =1; i<=300; i++) {
			 String subject = String.format("테스트데이터 : [%03d]", i);
			 String content = "내용 무 ";
			 this.questionService.create(subject, content);
		 }
	    }

}
