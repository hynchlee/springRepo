package com.kh.app.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.temp.KhConstPool;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
	
	private final BoardService service;

	// 게시글 목록
	@GetMapping("list")
	public String list(int p, Model model) {

		int listCount = service.getBoardCnt();
		int currentPage = p;
		int pageLimit = KhConstPool.PAGE_LIMIT;
		int boardLimit = KhConstPool.BOARD_LIMIT;
		
		PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
		
		List<BoardVo> voList = service.list(pv);
		
		model.addAttribute("voList", voList);
		
		return "board/list";
	}

	// 게시글 작성

	// 게시글 작성

}
