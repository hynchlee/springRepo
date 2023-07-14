package com.kh.app.board.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardVo {
	
	private String no;
	private String title;
	private String content;
	private String writerNo;
	private String categoryNo;
	private String enrollDate;
	private String status;
	private String modifyDate;
	private String hit;
}
