package com.adgile.user.common.response;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonResponse<T> {

	private T data;
	private Integer result;
	private String message;

	public static final CommonResponse<String> OK = new CommonResponse<>("", 200, "OK");

	public static <T> CommonResponse<T> success(T data) {
		return new CommonResponse<>(data, 200, "OK");
	}

	public static CommonResponse<Object> error(Integer result, String message) {
		return new CommonResponse<>("", result, message);
	}
}
