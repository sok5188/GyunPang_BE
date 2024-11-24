package com.gyunpang.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyunpang.be.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Integer> {
}
