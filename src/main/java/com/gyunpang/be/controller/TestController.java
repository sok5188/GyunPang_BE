package com.gyunpang.be.controller;

import java.util.Enumeration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gyunpang.be.dto.TestDto;
import com.gyunpang.be.service.KafkaConsumeService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
	private final KafkaConsumeService kafkaConsumeService;

	@GetMapping("/open/123")
	public ResponseEntity tst1() {
		return ResponseEntity.ok("openAPITEST");
	}

	@GetMapping("/auth")
	public ResponseEntity authTest(HttpServletRequest request) {
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = headerNames.nextElement();
			String value = request.getHeader(key);
			System.out.println("key = " + key + " / val : " + value);
		}
		return ResponseEntity.ok("AUTH_TEST");
	}

	@GetMapping("/query")
	public ResponseEntity queryTest(@RequestParam("name") String name, @RequestParam("age") Integer age) {
		log.info("[query] got name : {}, age : {}", name, age);
		return ResponseEntity.ok(name + age);
	}

	@PostMapping("/body")
	public ResponseEntity bodyTest(@RequestBody TestDto.TestBody body) {
		log.info("[body] got body : {}", body);
		return ResponseEntity.ok(body);
	}

	@RequestMapping("/nothing")
	public ResponseEntity nothingTest() {
		return ResponseEntity.ok("nothingReturn");
	}

	@RequestMapping("/makeError")
	public ResponseEntity errTest(@RequestParam("code") Integer code) {
		if (code.equals(400))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400Error");
		if (code.equals(500))
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("500Error");
		return ResponseEntity.ok("noErrorMatched");
	}
	// @RequestMapping("/callA")
	// public ResponseEntity callA(){
	// 	kafkaConsumeService.a();
	// 	return ResponseEntity.ok("A");
	// }
}
