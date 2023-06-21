package com.kh.app.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public String join(MemberVo vo) {
		
		int result = ms.join(vo);
		
		if(result != 1) {
			return "join FAIL";
		}
		
		return "join OK";
	}
	
	
	@GetMapping("login")
	public void login() {
		
	}
	
	@PostMapping("login")
	@ResponseBody
	public String login(MemberVo vo, HttpSession session) {
		
		MemberVo loginMember = ms.login(vo);
		
		session.setAttribute("loginMember", loginMember);
		
		if(loginMember == null) {
			return "login FAIL";
		}
		
		return "login OK";
	}
	
	@GetMapping("logout")
	@ResponseBody
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout OK";
	}
	
}
