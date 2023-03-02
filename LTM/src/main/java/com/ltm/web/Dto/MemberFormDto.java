package com.ltm.web.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {
	@Size(min=3, max=25)
	@NotEmpty(message = "사용자 id는 필수 항목입니다.")
	private String id;
	
	@NotEmpty(message = "비밀번호는 필수 항목입니다.")
	private String password1;
	
	@NotEmpty(message = "비밀번호 확인은 필수 항목입니다.")
	private String password2;

	@NotEmpty(message = "닉네임은 필수 항목입니다.")
	private String nickname;
	
	@Email
	@NotEmpty(message = "이메일은 필수 항목입니다.")
	private String email;
	
	private String phone;
	
	
	private String birth; 
	private LocalDateTime joindate;
	
}
