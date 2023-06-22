package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService ms;

	@GetMapping("join")
	public void join() {
		
	}
	
	@PostMapping("join")
	public String join(MemberVo vo) throws Exception {
		
		int result = ms.join(vo);
		
		if(result != 1) {
			throw new Exception("회원가입 실패");
		}
		
		return "redirect:/home";
	}
	

	@GetMapping("login")
	public void login() {
		
	}
	
	@PostMapping("login")
	public String login(Model model, MemberVo vo) {
		
		MemberVo loginMember = ms.login(vo);
		
		if(loginMember == null) {
			throw new RuntimeException("로그인 실패");
		}
		
		model.addAttribute("loginMember", loginMember);
		
		return "redirect:/home";
	}
	
}
