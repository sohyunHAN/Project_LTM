package com.ltm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String root() {
		//return "main";
		return "redirect:/cboard/list"; // 2023-02-27 승훈이가 잠시 수정
	}
	
}
