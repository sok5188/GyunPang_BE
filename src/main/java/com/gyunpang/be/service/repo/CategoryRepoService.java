package com.gyunpang.be.service.repo;

import org.springframework.stereotype.Service;

import com.gyunpang.be.dto.entityDto.CategoryDto;
import com.gyunpang.be.entity.BaseEntity;
import com.gyunpang.be.entity.CategoryEntity;
import com.gyunpang.be.mapper.CategoryMapper;
import com.gyunpang.be.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryRepoService {
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;

	public void save(CategoryDto dto) {
		CategoryEntity entity = categoryMapper.toEntity(dto);
		log.info("converted entity : " + entity.toString());
		CategoryEntity testManual = CategoryEntity.builder().name("testManual").build();
		BaseEntity b = testManual;
		log.info("conveted Manual : " + testManual.toString());
		log.info("base : " + b.toString());
		categoryRepository.save(testManual);
	}
}
