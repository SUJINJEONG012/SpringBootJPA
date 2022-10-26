package com.mysite.project;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/*
화면에서 전달되는 입력값을 검증하기 위해서 폼 클래스 필요
화면의 입력항목 subject, content에 대응하는 QuestionForm 클래스
 * */

@Getter
@Setter
public class QuestionForm {
	/*
	 *  @NotEmpty는 해당 값이 Null 또는 빈 문자열("")을 허용하지 않음을 의미
	 *  @Size(max=200) 최대 길이가 200 바이트를 넘으면 안된다는 의미
	 *  */
	@NotEmpty(message="제목은 필수 사항입니다.")
	@Size(max=200)
	private String subject;
	@NotEmpty(message="내용은 필수항목입니다. ")
	private String content;
}
