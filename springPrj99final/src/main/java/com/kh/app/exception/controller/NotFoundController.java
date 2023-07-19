package com.kh.app.exception.controller;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class NotFoundController {

	@RequestMapping("/*")
	public void acceptNotFound() throws Exception {
		
		throw new NotFoundException("notFound~!");
		
	}
	
}
