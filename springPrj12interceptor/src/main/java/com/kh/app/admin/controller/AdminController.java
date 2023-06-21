package com.kh.app.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	//관리자 메인페이지 보여주기
	@GetMapping("main")
	public String main() {
		
		return "admin/main";
	}
	
	//관리자 로그인(화면)
	@GetMapping("login")
	public void login(Model model) {
		System.out.println("컨트롤러 == 헨들러 호출...");
	}
}
