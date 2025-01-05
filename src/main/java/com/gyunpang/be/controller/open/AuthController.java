package com.gyunpang.be.controller.open;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gyunpang.be.dto.MemberInfoDto;
import com.gyunpang.be.service.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/open/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody MemberInfoDto.SignUpInfo info) {
		authService.signup(info);
		return ResponseEntity.ok("signup success");
	}

	@GetMapping("/checkUsername")
	public ResponseEntity<MemberInfoDto.CheckUsernameRes> checkUsername(@RequestParam("username") String username) {
		return ResponseEntity.ok(
			MemberInfoDto.CheckUsernameRes.builder()
				.isUsernameExist(authService.checkUsername(username))
				.build());
	}

	@GetMapping("/sendEmailCode")
	public ResponseEntity<MemberInfoDto.GetEmailCodeRes> sendEmailCode(@RequestParam("email") String email) {
		return ResponseEntity.ok(MemberInfoDto.GetEmailCodeRes.builder()
			.code(authService.sendVerifyCode(email))
			.build());
	}

	@PostMapping("/findUsername")
	public ResponseEntity<MemberInfoDto.FindUsernameRes> findUsername(@RequestBody MemberInfoDto.FindUsernameReq req) {
		return ResponseEntity.ok(MemberInfoDto.FindUsernameRes.builder()
			.username(authService.findUsername(req))
			.build());
	}

	@PutMapping("/resetPassword")
	public ResponseEntity<String> resetPassword(@RequestBody MemberInfoDto.ResetPasswordReq req) {
		authService.resetPassword(req);
		return ResponseEntity.ok("password reset");
	}

	@PutMapping("/signin")
	public ResponseEntity<String> signIn(@RequestBody MemberInfoDto.SignInReq req) {
		authService.signIn(req);
		return ResponseEntity.ok("sign in success");
	}

}
