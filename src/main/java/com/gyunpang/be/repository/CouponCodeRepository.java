package com.gyunpang.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyunpang.be.entity.CouponCodeEntity;

public interface CouponCodeRepository extends JpaRepository<CouponCodeEntity, Integer> {
}
