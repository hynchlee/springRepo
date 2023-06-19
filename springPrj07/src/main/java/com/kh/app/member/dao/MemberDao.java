package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

@Repository
public class MemberDao {

	public int join(MemberVo vo, SqlSessionTemplate sst) {
		return sst.insert("member.join", vo);
	}

	public MemberVo login(MemberVo vo, SqlSessionTemplate sst) {
		return sst.selectOne("member.login",vo);
	}

	public int edit(MemberVo vo, SqlSessionTemplate sst) {
		return sst.update("member.edit", vo);
	}

}
