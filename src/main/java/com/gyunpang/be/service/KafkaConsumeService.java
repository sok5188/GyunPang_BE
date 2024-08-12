package com.gyunpang.be.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumeService {
	@KafkaListener(topics = "${kafka.topic.log}", groupId = "be")
	public void consumeString(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) String partition) {
		log.info("[consumer] msg:{} from partition {}", message, partition);
	}
}
