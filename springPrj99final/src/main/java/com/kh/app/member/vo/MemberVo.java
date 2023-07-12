package com.kh.app.member.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberVo {

	private String no;
	private String id;
	private String pwd;
	private String nick;
	private String profile;
	private String hobby;
	private String status;
	private String enrollDate;
	private String modifyDate;
	
}
