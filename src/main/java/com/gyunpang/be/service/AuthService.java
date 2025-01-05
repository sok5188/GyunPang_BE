package com.gyunpang.be.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gyunpang.be.common.CommonCode;
import com.gyunpang.be.common.CommonUtil;
import com.gyunpang.be.common.CustomException;
import com.gyunpang.be.dto.MemberInfoDto;
import com.gyunpang.be.dto.entityDto.MemberDto;
import com.gyunpang.be.service.repo.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
	private final MemberService memberService;

	private MemberDto getMember(String username) {
		Optional<MemberDto> optionalMember = memberService.findMemberByUsername(username);
		if (optionalMember.isEmpty())
			throw new CustomException(CommonCode.AUTH_STATUS_MEMBER_NOT_EXIST);
		return optionalMember.get();
	}

	public void signup(MemberInfoDto.SignUpInfo info) {
		if (memberService.isUsernameExist(info.getUsername())) {
			throw new CustomException(CommonCode.AUTH_STATUS_DUPLICATE_ID);
		}
		if (memberService.isEmailExist(info.getEmail())) {
			throw new CustomException(CommonCode.AUTH_STATUS_DUPLICATE_EMAIL);
		}

		memberService.registerUser(info);
	}

	public boolean checkUsername(String username) {
		return memberService.isUsernameExist(username);
	}

	public String sendVerifyCode(String email) {
		//TODO : smtp 연결하고 인증코드 보내고 또 받는 로직 추가
		return "verify";
	}

	public String findUsername(MemberInfoDto.FindUsernameReq req) {
		Optional<MemberDto> optionalMember = memberService.findMemberByNameAndEmail(req.getName(),
			req.getEmail());
		if (optionalMember.isEmpty())
			throw new CustomException(CommonCode.AUTH_STATUS_MEMBER_NOT_EXIST);
		return optionalMember.get().getUsername();
	}

	public void resetPassword(MemberInfoDto.ResetPasswordReq req) {
		MemberDto member = getMember(req.getUsername());
		if (!member.getEmail().equals(req.getEmail()))
			throw new CustomException(CommonCode.AUTH_STATUS_EMAIL_NOT_EXIST);

		String tempPassword = CommonUtil.makeRandomPassword();

		//TODO : smtp 연결하고 인증코드 보내고 또 받는 로직 추가
		//mailservice. send temp pwd

		member = member.toBuilder().password(tempPassword).build();
		memberService.save(member);
	}

	public void signIn(MemberInfoDto.SignInReq req) {
		MemberDto member = getMember(req.getUsername());
		String encryptedPassword = CommonUtil.passwordEncoder(req.getPassword());
		if (!encryptedPassword.equals(member.getPassword()))
			throw new CustomException(CommonCode.AUTH_STATUS_INVALID_PASSWORD);
		//TODO : 토큰 발급 기능 추가

	}
}
