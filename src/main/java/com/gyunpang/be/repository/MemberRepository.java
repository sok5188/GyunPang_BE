package com.gyunpang.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyunpang.be.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

}
