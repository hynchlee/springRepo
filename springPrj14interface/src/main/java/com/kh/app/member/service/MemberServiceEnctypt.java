package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
@Primary
public class MemberServiceEnctypt implements MemberService{

	private final SqlSessionTemplate sst;
	private final MemberDao dao;
	private final BCryptPasswordEncoder encoder;

	@Override
	public MemberVo login(MemberVo vo) {
		
		MemberVo loginMember = dao.login(vo, sst);
		
		String dbPwd = loginMember.getPwd();
		String userPwd = vo.getPwd();
		
		boolean isMatch = encoder.matches(userPwd, dbPwd);
		
		if (!isMatch) {
			throw new RuntimeException();
		}
		
		return loginMember;
	}

	@Override
	public int join(MemberVo vo) {
		
		//암호화
		String pwd = vo.getPwd();
		String newPwd = encoder.encode(pwd);
		vo.setPwd(newPwd);
		
		return dao.join(vo, sst);
		
	}
	
}
