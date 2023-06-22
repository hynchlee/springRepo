package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceDefault implements MemberService{

	private final MemberDao dao;
	private final SqlSessionTemplate sst;

	public int join(MemberVo vo) {
		return dao.join(vo, sst);
	}



	public MemberVo login(MemberVo vo) {
		return dao.login(vo, sst);
	}

	
}
