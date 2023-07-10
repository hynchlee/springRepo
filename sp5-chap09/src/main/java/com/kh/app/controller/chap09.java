package com.kh.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class chap09 {

	@RequestMapping("hello")
	public String m01(String name, Model model) {
				
		model.addAttribute("name", name);
		
		return "hello";
	}
	
}
