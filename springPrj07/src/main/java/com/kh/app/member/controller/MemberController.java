package com.kh.app.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	private final MemberService ms;

	public MemberController(MemberService ms) {
		this.ms = ms;
	}
	
	@GetMapping("join")
	public String join() {

		return "member/join";
	}

	@PostMapping("join")
	public String join(MemberVo vo) {
		
		int result = ms.join(vo);
		
		if(result != 1) {
			return "redirect:/errorPage";
		}
	
		return "redirect:/home";
		
	}
	
	@GetMapping("login")
	public String login() {
		
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberVo vo) {
		
		MemberVo loginMember = ms.login(vo);
		
		if(loginMember == null) {
			return "redirect:/errorPage";
		}
		
		return "redirect:/home";
	}
	
	@GetMapping("edit")
	public String edit() {
		
		return "member/edit";
	}
	
	@PostMapping("edit")
	public String edit(MemberVo vo) {
		
		int result = ms.edit(vo);
		
		if(result != 1) {
			return "redirect:/errorPage";
		}
		
		return "redirect:/home";
	}
	
	@RequestMapping("list")
	public String getMemberList(MemberVo vo, Model model) {
		
		List<MemberVo> memberList = ms.getMemberList(vo.getNo());
		
		model.addAttribute("memberList", memberList);
		
		return "member/list";
	}
	
}
