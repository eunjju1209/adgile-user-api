package com.adgile.user.infrastructure.user;

import com.adgile.user.common.exception.BusinessException;
import com.adgile.user.common.exception.ErrorCode;
import com.adgile.user.domain.user.User;
import com.adgile.user.domain.user.UserConditional;
import com.adgile.user.domain.user.UserReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

	private final UserRepository userRepository;

	@Override
	public User findUser(UserConditional where) {
		var user = userRepository.findUser(where)
				.orElseThrow(() -> new BusinessException(ErrorCode.NOT_EXIST_USER));
		return user;
	}

	@Override
	public void isValidationUser(UserConditional where) {
		// 같은 아이디가 있거나 측정되는 유저있을때, 오류 내보내기
//		var user = userRepository.findUser(where)
//				.orElseThrow(() -> new BusinessException(ErrorCode.EXIST_USER));

		userRepository.findUser(where)
				.ifPresent(entity -> {
					throw new BusinessException(ErrorCode.EXIST_USER);
				});
	}
}
