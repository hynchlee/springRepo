package com.kh.app.board.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.page.vo.PageVo;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Override
	public List<BoardVo> list(SqlSessionTemplate sst, PageVo p) {
		RowBounds rb = new RowBounds(p.getOffset(), p.getBoardLimit());
		return sst.selectList("board.selectBoardList", null, rb);
	}

	@Override
	public int write(SqlSessionTemplate sst, BoardVo vo) {
		return sst.insert("board.write", vo);
	}

	@Override
	public BoardVo detail(SqlSessionTemplate sst, String no) {
		return sst.selectOne("board.getBoard", no);
	}

	@Override
	public int edit(SqlSessionTemplate sst, BoardVo vo) {
		return sst.update("board.edit", vo);
	}

	@Override
	public int delete(SqlSessionTemplate sst, BoardVo vo) {
		return sst.delete("board.delete", vo.getNo());
	}

	@Override
	public int increaseHit(SqlSessionTemplate sst, String no) {
		return sst.update("board.increaseHit", no);
	}
	
	public int getBoardCnt(SqlSessionTemplate sst) {
		return sst.selectOne("board.getBoardCnt");
	}
	
}
