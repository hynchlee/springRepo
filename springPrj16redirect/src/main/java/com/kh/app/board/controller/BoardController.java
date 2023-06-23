package com.kh.app.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("board")
public class BoardController {

	@GetMapping("detail/{no}")
	@ResponseBody
	public String detail(@PathVariable String no) {
		return no + "게시글 상세조회";
	}
	
}
