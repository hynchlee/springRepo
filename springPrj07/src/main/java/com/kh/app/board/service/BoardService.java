package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

@Service
public class BoardService {

	private final SqlSessionTemplate sst;
	private final BoardDao dao;
	
	public BoardService(SqlSessionTemplate sst, BoardDao dao) {
		super();
		this.sst = sst;
		this.dao = dao;
	}

	public int write(BoardVo vo) {
				
		return dao.write(vo, sst);
	}

	public List<BoardVo> selectList() {
		return dao.selectList(sst);
	}

}
