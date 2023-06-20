package com.kh.app.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("test")
	public String test(String msg) {
		
		System.out.println(msg);
		
		return "AA";
	}
	
}
