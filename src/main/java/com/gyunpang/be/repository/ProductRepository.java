package com.gyunpang.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyunpang.be.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
