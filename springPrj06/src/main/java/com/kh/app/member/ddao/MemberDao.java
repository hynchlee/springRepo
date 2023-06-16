package com.kh.app.member.ddao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.kh.app.member.vo.MemberVo;

@Component
public class MemberDao {

	public int join(MemberVo vo, SqlSessionTemplate sst) {
		return sst.insert("member.join", vo);
	}

	public MemberVo login(MemberVo vo, SqlSessionTemplate sst) {
		return sst.selectOne("member.login", vo);
	}

}
