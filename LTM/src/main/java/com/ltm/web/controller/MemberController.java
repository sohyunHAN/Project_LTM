package com.ltm.web.controller;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltm.web.Dto.MemberFormDto;
import com.ltm.web.Service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;
	
	@GetMapping("/create")
	public String create(MemberFormDto memberFormDto) {
		return "MemberCreate";
	}
	
	@PostMapping("/create")
	public String create(@Valid MemberFormDto memberFormDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "MemberCreate";
		}
		if(!memberFormDto.getPassword1().equals(memberFormDto.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");
			return "MemberCreate";
		}
		
		try {
		memberService.create(memberFormDto.getId(), memberFormDto.getPassword1(), 
				memberFormDto.getNickname(), memberFormDto.getEmail(),
				memberFormDto.getPhone(),
				memberFormDto.getBirth(), memberFormDto.getJoindate());
		} catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
			return "MemberCreate";
		} catch(Exception e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", e.getMessage());
			return "MemberCreate";
		}
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
}
