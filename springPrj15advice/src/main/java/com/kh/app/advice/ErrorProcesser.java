package com.kh.app.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kh.app.exception.KhException;

//@ControllerAdvice(basePackages = "com.kh.app.member.controller")

@ControllerAdvice(annotations = Controller.class)
public class ErrorProcesser {

	@ExceptionHandler(Exception.class)
	public String m01(Exception e) {
		System.out.println("ErrorProcesser > m01 call");
		System.out.println(e.getMessage());
		return "errorPage~~";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String m02() {
		return "NullPoint";
	}
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public String m03() {
		return "Array";
	}
	
	@ExceptionHandler(KhException.class)
	public String notFoundHandler() {
		return "error/notFoundPage";
	}
}
