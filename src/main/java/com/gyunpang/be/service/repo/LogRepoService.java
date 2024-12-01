package com.gyunpang.be.service.repo;

import org.springframework.stereotype.Service;

import com.gyunpang.be.dto.LogDto;
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
		logRepository.save(logMapper.toEntity(logDto));
	}
}
