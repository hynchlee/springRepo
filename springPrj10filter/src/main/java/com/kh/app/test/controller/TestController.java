package com.kh.app.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

	//메세지 작성 화면
	@GetMapping("test")
	public String test() {
		return "msgForm";
	}

	@PostMapping("test")
	public String test(String msg, HttpServletRequest req) throws Exception {
		System.out.println(msg);
		return "aa";
	}
	
}
