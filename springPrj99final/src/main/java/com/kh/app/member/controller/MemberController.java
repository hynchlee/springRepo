package com.kh.app.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

	private final MemberService ms;
	
	@GetMapping("join")
	public void join() {
		
	}
	
	@PostMapping("join")
	public String join(MemberVo vo) {
		
		int result = ms.join(vo);
		log.info("result : {}", result);
		if(result != 1) {
			throw new IllegalStateException("회원가입 실패");
		}
		
		return "redirect:/";
	}
	
	@PostMapping("login")
	public String login(MemberVo vo, HttpSession session) {
		
		MemberVo loginMember = ms.login(vo);
		log.info("로그인 결과 : {}", loginMember);
		session.setAttribute("loginMember", loginMember);
		if (loginMember == null) {
			throw new IllegalStateException("로그인 실패");
		}
		
		return "home";
	}
	
	@GetMapping("edit")
	public void edit() {
		
	}
	
	@PostMapping("edit")
	public String edit(MemberVo vo) {
		
		int result = ms.edit(vo);
		
		if(result != 1) {
			return "redirect:/errorPage";
		}
		
		return "home";
	}
	
	@PostMapping("quit")
	public String quit(MemberVo vo) {
		
		int result = ms.quit(vo);
		
		if(result != 1) {
			throw new RuntimeException();
		}
		
		return "home";
	}
	
}
