package com.adgile.user.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ErrorCode {
	EXIST_USER(403, "존재하는 회원입니다."),
	NOT_EXIST_USER(403, "존재하지 않는 회원입니다.")
	;

	private Integer code;
	private String message;


	ErrorCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
