package com.kh.app.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KhInterceptor implements HandlerInterceptor {

	private static final ThreadLocal<UUID> Local = new ThreadLocal<UUID>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.setAttribute("reqId", UUID.randomUUID());
//		Local.set();
		log.info("[{}] 요청받은 URI : {}", request.getAttribute("reqId"), request.getRequestURI());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("[{}] 모델 & 뷰 : {}", request.getAttribute("reqId"), modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("[{}]화면생성 완료, 예외 {}", request.getAttribute("reqId"), ex);
	}

}
