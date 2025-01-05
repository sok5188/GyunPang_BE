package com.gyunpang.be.service.repo;

import org.springframework.stereotype.Service;

import com.gyunpang.be.dto.entityDto.LogDto;
import com.gyunpang.be.entity.LogEntity;
import com.gyunpang.be.mapper.LogMapper;
import com.gyunpang.be.repository.LogRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogRepoService {
	private final LogRepository logRepository;
	private final LogMapper logMapper;

	@Transactional
	public void save(LogDto logDto) {
		log.info("dto : " + logDto.toString());
		LogEntity entity = logMapper.toEntity(logDto);
		log.info("entity : " + entity.toString());
		logRepository.save(logMapper.toEntity(logDto));
	}
}
