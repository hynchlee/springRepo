package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.kh.app.board.vo.BoardVo;

@Component
public class BoardDao {

	public int write(BoardVo vo, SqlSessionTemplate sst) {
		return sst.insert("board.write", vo);
	}

	public List<BoardVo> selectList(SqlSessionTemplate sst) {
		return sst.selectList("board.selectList");
	}

}
