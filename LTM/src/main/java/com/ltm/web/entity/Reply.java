package com.ltm.web.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // 댓글번호
	
	@Column(columnDefinition = "TEXT")
	private String rbody; // 댓글
	
	private LocalDateTime wdate; // 작성일
	
	private LocalDateTime mdate; // 수정일
	
	@ManyToOne
	private Cboard cboard; // N:1
	
	@ManyToOne
	private Member nickname; // 작성자
	
	@ManyToMany
    Set<Member> voter;

}
