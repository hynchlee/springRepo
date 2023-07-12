package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.member.dao.MemberDaoImpl;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

	private final SqlSessionTemplate sst;
	private final MemberDaoImpl dao;
	private final BCryptPasswordEncoder pwdEncoder;

	@Override
	public int join(MemberVo vo) {

		if(vo.getPwd().length() < 4) {
			throw new RuntimeException("비밀번호는 4글자 이상");
		}
		
		String pwd = vo.getPwd();
		String newPwd = pwdEncoder.encode(pwd);
		vo.setPwd(newPwd);

		return dao.join(sst, vo);
	}

	@Override
	public MemberVo login(MemberVo vo) {

		MemberVo loginMember = dao.login(sst, vo);

//		boolean isMatch = loginMember.getPwd().equals(vo.getPwd());
//		boolean isMatch = pwdEncoder.matches(평문, 암호문);
		// 암호화 처리
		boolean isMatch = pwdEncoder.matches(vo.getPwd(), loginMember.getPwd());

		if (!isMatch) {
			return null;
		}

		return loginMember;
	}

	@Override
	public int edit(MemberVo vo) {
		return dao.edit(sst, vo);
	}

	@Override
	public int quit(MemberVo vo) {
		return dao.quit(sst, vo);
	}

}
