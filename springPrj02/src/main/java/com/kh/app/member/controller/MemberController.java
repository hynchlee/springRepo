package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {

	//회원가입 화면 보여주기
//	@RequestMapping(value = "member/join", method = RequestMethod.GET)
	@GetMapping(value = "member/join")
	public String join() {
		
		
		
		return "member/join";
	}
	
	//회원가입 처리
//	@RequestMapping(value = "member/join", method = RequestMethod.POST)
	@PostMapping(value = "member/join")
	public String join2(MemberVo vo) {
		
		System.out.println(vo);
		System.out.println("회원가입 진행~~");
				
		return "redirect:/";
	}
	
	
	@RequestMapping("member/login")
	public String login() {
	
		
		return "member/login";
	}
	
}
