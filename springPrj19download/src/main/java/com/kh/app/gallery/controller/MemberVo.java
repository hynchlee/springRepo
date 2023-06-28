package com.kh.app.gallery.controller;

import lombok.Data;

@Data
public class MemberVo {

	//생성자
	private MemberVo(MemberTemp temp) {
		this.id = temp.id;
		this.pwd = temp.pwd;
		this.nick = temp.nick;
	}
	
	//객체 생성을 위한 메소드
	public static MemberVo build() {
		
		
		return new MemberVo(null);
	}
	
	//임시객체 생성을 위한 메소드
	public static MemberTemp temp() {
		
		return new MemberTemp();
	}
	
	private String id;
	private String pwd;
	private String nick;

	
	//static 클래스
	static class MemberTemp {

		private String id;
		private String pwd;
		private String nick;
		
		MemberTemp id(String id) {
			this.id = id;
			return this;
		}
		
		MemberTemp pwd(String pwd) {
			this.pwd = pwd;
			return this;
		}
		
		MemberTemp nick(String nick) {
			this.nick = nick;
			return this;
		}
		
		public void m01() {
			MemberVo vo = MemberVo.temp().id("user01").pwd("1234").nick("nick01")
			.build();
		}
		
		MemberVo build() {
			return new MemberVo(this);
		}
	}

}
