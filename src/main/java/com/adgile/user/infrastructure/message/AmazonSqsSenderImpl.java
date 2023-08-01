package com.adgile.user.infrastructure.message;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class AmazonSqsSenderImpl implements AmazonSqsSender {

	@Value("${cloud.aws.sqs.queue.url}")
	private String url;

	private final AmazonSQS sqs;
	private final ObjectMapper objectMapper;

	@Override
	public SendMessageResult sendMessage(Object message) {
		try {
			var test = objectMapper.writeValueAsString(message);
			SendMessageRequest request = new SendMessageRequest(url, test)
					.withMessageGroupId("adgile-group")
					.withMessageDeduplicationId(UUID.randomUUID().toString());
			return sqs.sendMessage(request);
		} catch (Exception e) {
			log.error("aws sqs sender error", e);
		}

		return null;
	}
}
