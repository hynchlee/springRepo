package com.kh.app.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberController {

	private final MemberService ms;
	
	@Autowired
	public MemberController(MemberService ms) {
		this.ms = ms;
	}

	
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(MemberVo vo) throws Exception{
		
		int result = ms.join(vo);
		
		if(result != 1) {
			throw new Exception("회원가입 실패");
		}
		
		return "redirect:/home";
	}


	@GetMapping("login")
	public String login() {
		return "member/login";
	}

	@PostMapping("login")
	public String login(MemberVo vo) throws Exception{
		
		MemberVo loginMember = ms.login(vo);
		
		if(loginMember == null) {
			throw new Exception("로그인 실패");
		}
		
		return "redirect:/home";
	}
	
}
