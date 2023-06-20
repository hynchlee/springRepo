package com.kh.app.home.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	//홈페이지
	@GetMapping(value = {"/", "home"})
	public String home() {
		
		return "home";
	}
	
	//로그인 처리
	@GetMapping("login")
	public String login(Model model, HttpSession session) {
	
//		model.addAttribute("nick", "이현철");
		session.setAttribute("nick", "잏넟");
		return "redirect:/";
	}
	
	
	
}
