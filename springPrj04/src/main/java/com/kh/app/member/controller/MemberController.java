package com.kh.app.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {

	
	private final MemberService ms;
	
	@Autowired
	public MemberController(MemberService ms) {
		super();
		this.ms = ms;
	}
	
	@GetMapping(value = "member/join")
	public String join(){
		
		return "member/join";
		
	}

	@PostMapping(value = "member/join")
	public String join(MemberVo vo) {
		
		int result = ms.join(vo);
		
		if(result != 1) {
			return "errorPage";
		}

		return "successPage";

	}
	
}
