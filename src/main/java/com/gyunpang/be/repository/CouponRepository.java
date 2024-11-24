package com.gyunpang.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyunpang.be.entity.CouponEntity;

public interface CouponRepository extends JpaRepository<CouponEntity, Integer> {
}
