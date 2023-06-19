package com.kh.app.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
public class MemberService {

	private final MemberDao dao;
	private final SqlSessionTemplate sst;
	
	@Autowired
	public MemberService(MemberDao dao, SqlSessionTemplate sst) {
		this.dao = dao;
		this.sst = sst;
	}

	public int join(MemberVo vo) {
		
		int result = dao.join(vo, sst);
		
		return result;
	}

	public MemberVo login(MemberVo vo) {
		
		MemberVo loginMember = dao.login(vo, sst);
		
		return loginMember;
	}

	public int edit(MemberVo vo) {
		
		int result = dao.edit(vo, sst);
		
		return result;
	}

	public List<MemberVo> getMemberList(String no) {
		return null;
	}
	
	
	
}
