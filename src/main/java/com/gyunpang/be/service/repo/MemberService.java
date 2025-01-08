package com.gyunpang.be.service.repo;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gyunpang.be.common.util.CommonUtil;
import com.gyunpang.be.dto.MemberInfoDto;
import com.gyunpang.be.dto.entityDto.MemberDto;
import com.gyunpang.be.entity.MemberEntity;
import com.gyunpang.be.mapper.MemberMapper;
import com.gyunpang.be.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class MemberService {
	private final MemberRepository memberRepository;
	private final MemberMapper memberMapper;

	public boolean isEmailExist(String email) {
		return memberRepository.findMemberByEmail(email).isPresent();
	}

	public boolean isUsernameExist(String username) {
		return memberRepository.findMemberByUsername(username).isPresent();
	}

	public void registerUser(MemberInfoDto.SignUpInfo info) {
		MemberDto dto = MemberDto.builder()
			.username(info.getUsername())
			.nickname(info.getNickname())
			.email(info.getEmail())
			.userType(info.getUserType())
			.password(CommonUtil.passwordEncoder(info.getPassword()))
			.build();
		memberRepository.save(memberMapper.toEntity(dto));
	}

	public Optional<MemberDto> findMemberByNameAndEmail(String name, String email) {
		Optional<MemberEntity> optionalMember = memberRepository.findMemberByNameAndEmail(name, email);
		return optionalMember.map(memberMapper::toDto);
	}

	public Optional<MemberDto> findMemberByUsername(String username) {
		return memberRepository.findMemberByUsername(username)
			.map(memberMapper::toDto);
	}

	public void save(MemberDto memberDto) {
		memberRepository.save(memberMapper.toEntity(memberDto));
	}
}
