package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao{

	public int join(SqlSessionTemplate sst, MemberVo vo) {
		return sst.insert("member.join", vo);
	}

	public MemberVo login(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("member.login", vo);
	}

	public int edit(SqlSessionTemplate sst, MemberVo vo) {
		return 0;
	}

	public int quit(SqlSessionTemplate sst, MemberVo vo) {
		return 0;
	}

}
