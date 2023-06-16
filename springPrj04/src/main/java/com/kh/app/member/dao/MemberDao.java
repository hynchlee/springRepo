package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

@Repository
public class MemberDao {

	public int join(MemberVo vo, SqlSessionTemplate sst) {
		return sst.insert("member.join", vo);
	}

}
