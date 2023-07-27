package com.adgile.user.common.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BusinessException extends RuntimeException {

	private final ErrorCode errorCode;

	public BusinessException(ErrorCode errorCode) {
		// super 이유 확인 필요하다.
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
}
