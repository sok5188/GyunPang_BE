package com.gyunpang.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyunpang.be.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
}
