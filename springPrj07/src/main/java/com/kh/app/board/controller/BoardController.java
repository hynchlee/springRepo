package com.kh.app.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@Controller
@RequestMapping("board")
public class BoardController {

	private final BoardService bs;
	
	@Autowired
	public BoardController(BoardService bs) {
		this.bs = bs;
	}

	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("write")
	public String write(BoardVo vo) {
		
		int result = bs.write(vo);
		
		if(result != 1) {
			return "redirect:/errorPage";
		}
		
		return "redirect:/board/list";
	}
	

	@GetMapping("list")
	public String list() {
		
		List<BoardVo> voList = bs.selectList();
		
		System.out.println(voList);
		
		return "board/list";
	}
	
}
