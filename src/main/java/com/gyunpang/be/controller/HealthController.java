package com.gyunpang.be.controller;

import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HealthController {
	@Autowired
	private Environment environment;
	@GetMapping("/health")
	public ResponseEntity healtCheck(){
		log.info("Got Health Check");
		if(environment.containsProperty("CONTAINER_COLOR")){
			String customEnv = environment.getProperty("CONTAINER_COLOR");
			return ResponseEntity.ok(customEnv + " hello");
		}
		else return ResponseEntity.ok("Cannot find color");
	}
	@GetMapping("/open/123")
	public ResponseEntity tst1(){
		return ResponseEntity.ok("openAPITEST");
	}

	@GetMapping("/authTest")
	public ResponseEntity authTest(HttpServletRequest request){
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()){
			String key = headerNames.nextElement();
			String value = request.getHeader(key);
			System.out.println("key = " + key+" / val : "+ value);
		}
		return ResponseEntity.ok("AUTH_TEST");
	}
}
