package com.ltm.web.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member {

	@Id
	private String id;
	
	private String password;
	
	@Column(nullable = false, unique = true)
	private String nickname;

	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(unique = true)
	private String phone;
	
	@Column(nullable = false)
	private String birth;
	
	@Column(nullable = false)
	private LocalDateTime joindate; //테스트
	
	
	


}
