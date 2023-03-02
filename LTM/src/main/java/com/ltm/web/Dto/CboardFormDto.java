package com.ltm.web.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CboardFormDto {
	
	@NotEmpty(message="제목을 입력해주세요😊")
	@Size(max=50)
	private String ctitle;
	
	@NotEmpty(message="내용을 입력해주세요😊")
	private String cbody;

}
