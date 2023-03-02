package com.ltm.web.Dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyFormDto {
	
	@NotEmpty(message = "내용을 입력해주세요😊")
	private String rbody;

}
