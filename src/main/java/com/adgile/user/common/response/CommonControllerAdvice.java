package com.adgile.user.common.response;

import com.adgile.user.common.exception.BusinessException;
import com.adgile.user.common.exception.ErrorCode;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class CommonControllerAdvice {

	private static final List<ErrorCode> SPECIFIC_ALERT_TARGET_ERROR_CODE_LIST = Lists.newArrayList();

	/**
	 * http status: 500 And result : fail
	 * 시스템 예외상황. 집중 모니터링 대상
	 */

	@ExceptionHandler(BusinessException.class)
	public CommonResponse<Object> handleBusinessException(BusinessException e) {
		final ErrorCode errorCode = e.getErrorCode();
		log.error("BusinessException 발생");
		return CommonResponse.error(errorCode.getCode(), e.getMessage());
	}
}
