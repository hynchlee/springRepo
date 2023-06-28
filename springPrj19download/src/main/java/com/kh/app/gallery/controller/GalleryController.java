package com.kh.app.gallery.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("gallery")
public class GalleryController {

	@GetMapping("list")
	public void list() {

	}

	// 사진 다운로드(기존방식)
//	@GetMapping("download")
	public void download(HttpServletResponse resp, HttpServletRequest req) throws Exception {

		// 파일이 없을 때
		// resp.sendError(404);

		// 헤더 셋팅
		resp.setHeader("Content", "application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment; filename=hello.jpg");
		resp.setHeader("Content-Length", "598194");

		// 파일내보내기
		String root = req.getServletContext().getRealPath("/resources/img/");
		String path = root + "20210118_news01.jpg";
		File target = new File(path);
		byte[] data = FileUtils.readFileToByteArray(target);
		resp.getOutputStream().write(data);

	}

	// 사진 다운로드(스프링방식)
	@GetMapping("download")
	public ResponseEntity<byte[]> download(HttpServletRequest req) throws Exception {

		// 파일 객체 준비 == 바이트 배열 준비
		String root = req.getServletContext().getRealPath("/resources/img/");
		String path = root + "20210118_news01.jpg";
		File target = new File(path);
		byte[] data = FileUtils.readFileToByteArray(target);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(target.length())
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=hi.jpg")
				.header(HttpHeaders.CONTENT_ENCODING, "UTF-8").body(data);

	}

}
