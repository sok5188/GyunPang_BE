package com.gyunpang.be.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyunpang.be.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
	Optional<MemberEntity> findMemberByEmail(String email);

	Optional<MemberEntity> findMemberByUsername(String username);

	Optional<MemberEntity> findMemberByNameAndEmail(String name, String email);
}
