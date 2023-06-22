package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

	private final BoardDao dao;
	private final SqlSessionTemplate sst;


	public int write(BoardVo vo) {
		return dao.write(vo, sst);
	}



	public List<BoardVo> getBoardList() {
		return dao.getBoardList(sst);
	}


	@Transactional
	public BoardVo getBoardOneByNo(String no) {
		int result = dao.increaseHit(no, sst);
		if(result != 1) {
			throw new RuntimeException("조회수 증가 실패");
		}
		return dao.getBoardOneByNo(no, sst);
	}

}
