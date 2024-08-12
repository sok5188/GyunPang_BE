package com.gyunpang.be.event.kafka;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KafkaMessageEvent {
	private String topic;
	private String context;
}
