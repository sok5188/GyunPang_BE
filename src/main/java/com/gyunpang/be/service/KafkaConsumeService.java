package com.gyunpang.be.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.gyunpang.be.dto.LogDto;
import com.gyunpang.be.service.repo.LogRepoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumeService {
	private final LogRepoService logRepoService;

	@KafkaListener(topics = "${kafka.topic.log}", groupId = "be")
	public void consumeString(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) String partition) {
		LogDto restLog = parseRestLogDto(message);
		log.info("restLog : " + restLog);
		logRepoService.save(restLog);
	}

	private LogDto parseRestLogDto(String message) {
		String[] split = message.split("`;`");
		Map<String, String> logInfoMap = new HashMap<>();
		for (String s : split) {
			log.trace("split : " + s);
			String[] keyValue = s.split("`:`");
			if (keyValue.length != 2) {
				log.warn("key and value is not formatted check gateway log format, now length : " + keyValue.length);
				continue;
			}

			String key = keyValue[0];
			String value = keyValue[1];

			logInfoMap.put(key, value);
		}

		return LogDto.builder()
			.uri(logInfoMap.getOrDefault("uri", "uriDefault"))
			.routeId(logInfoMap.getOrDefault("routeId", "routeIdDefault"))
			.route(logInfoMap.getOrDefault("routeUri", "routeDefault"))
			.statusCode(logInfoMap.getOrDefault("statusCode", "statusDefault"))
			.method(logInfoMap.getOrDefault("method", "methodDefault"))
			.createDateTime(LocalDateTime.parse(
				logInfoMap.getOrDefault("createDt", LocalDateTime.of(1998, 8, 8, 8, 8, 8).toString()),
				DateTimeFormatter.ISO_LOCAL_DATE_TIME))
			.body(logInfoMap.getOrDefault("body", "defaultBody"))
			.requestId(logInfoMap.getOrDefault("requestId", "defaultRequestId"))
			.type(logInfoMap.getOrDefault("type", "defaultType"))
			.userId(logInfoMap.getOrDefault("userId", "default"))
			.build();
	}
}
