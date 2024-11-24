package com.gyunpang.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyunpang.be.entity.LogEntity;

public interface LogRepository extends JpaRepository<LogEntity, Integer> {
}
