package com.gyunpang.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyunpang.be.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
}
