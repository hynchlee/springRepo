package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardDao {

	public int write(BoardVo vo, SqlSessionTemplate sst) {
		return sst.insert("board.write", vo);
	}

	public List<BoardVo> getBoardList(SqlSessionTemplate sst) {
		return sst.selectList("board.getBoardList");
	}

	public BoardVo getBoardOneByNo(String no, SqlSessionTemplate sst) {
		return sst.selectOne("board.getBoardOneByNo", no);
	}
	
	public int increaseHit(String no, SqlSessionTemplate sst) {
		return sst.update("board.increaseHit", no);
	}

}
