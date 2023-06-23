package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

	private final MemberService ms;
	
	@GetMapping("join")
	public void join() {
		
	}
	
	@PostMapping("join")
	@ResponseBody
	public String join(MemberVo vo) throws Exception {
		
		int result = ms.join(vo);
		
		if(result != 1) {
			throw new RuntimeException();
		}
		
		return "join Ok";
	}
	
	
	@GetMapping("login")
	public void login() {
		
	}
	
	@PostMapping("login")
	@ResponseBody
	public String login(MemberVo vo) {
		
		MemberVo loginMember = ms.login(vo);
		
		if(loginMember == null) {
			throw new RuntimeException();
		}
		
		return "login Ok";
	}
	
}
