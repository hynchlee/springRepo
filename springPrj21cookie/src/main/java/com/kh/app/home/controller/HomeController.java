package com.kh.app.home.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@GetMapping("test")
	@ResponseBody
	public String test(HttpSession session) {
		return "test~~";
	}

	@RequestMapping
	public String home(@CookieValue(required = false, name = "JSESSIONID") Cookie c) {
		
		System.out.println(c.getName() + "/" + c.getValue());
		
//		Cookie[] cookieArr = req.getCookies();
//		
//		for(Cookie cookie : cookieArr) {
//			System.out.println(cookie.getName() + "/" + cookie.getValue());
//		}
		
		return "home";
	}
	
}
