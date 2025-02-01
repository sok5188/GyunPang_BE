package com.gyunpang.be.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gyunpang.be.service.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
	private final FileService fileService;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(
		@RequestPart("file") MultipartFile file // 이미지 파일
		// @RequestPart("metadata") String metadataJson // JSON 데이터
	) throws IOException {

		// JSON 데이터 처리
		// Metadata metadata = new ObjectMapper().readValue(metadataJson, Metadata.class); // JSON -> Java 객체 변환
		// System.out.println("Title: " + metadata.getTitle());
		// System.out.println("Description: " + metadata.getDescription());

		return ResponseEntity.ok(fileService.uploadFile(file));
	}

	@GetMapping("/getUrl")
	public ResponseEntity<String> getSignUrl(@RequestParam("filename") String filename) {
		return ResponseEntity.ok(fileService.getSignedUrl(filename));
	}
}
