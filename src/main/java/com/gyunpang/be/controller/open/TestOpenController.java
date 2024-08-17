package com.gyunpang.be.controller.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/open")
@RequiredArgsConstructor
public class TestOpenController {
	@GetMapping("/hello")
	public ResponseEntity tst1() {
		return ResponseEntity.ok("openAPITEST");
	}

	@Autowired
	private Environment environment;

	@GetMapping("/color")
	public ResponseEntity healtCheck() {
		log.info("Got Health Check");
		if (environment.containsProperty("CONTAINER_COLOR")) {
			String customEnv = environment.getProperty("CONTAINER_COLOR");
			return ResponseEntity.ok(customEnv + " hello");
		} else
			return ResponseEntity.ok("Cannot find color");
	}

}
