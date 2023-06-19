package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.member.ddao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
public class MemberService {

	private final SqlSessionTemplate sst;
	private final MemberDao dao;
	
	@Autowired
	public MemberService(SqlSessionTemplate sst, MemberDao dao) {
		super();
		this.sst = sst;
		this.dao = dao;
	}



	public int join(MemberVo vo) {		
		return dao.join(vo, sst);
	}



	public MemberVo login(MemberVo vo) {
		return dao.login(vo, sst);
		
	}

}
