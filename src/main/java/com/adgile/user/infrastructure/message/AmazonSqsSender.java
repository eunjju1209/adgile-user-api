package com.adgile.user.infrastructure.message;

import com.amazonaws.services.sqs.model.SendMessageResult;

public interface AmazonSqsSender {
	SendMessageResult sendMessage(Object message);
}
