package com.gyunpang.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyunpang.be.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
