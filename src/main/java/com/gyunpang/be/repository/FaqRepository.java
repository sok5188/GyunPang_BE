package com.gyunpang.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyunpang.be.entity.FaqEntity;

public interface FaqRepository extends JpaRepository<FaqEntity, Integer> {
}
