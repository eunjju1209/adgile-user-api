package com.adgile.user.application.service.user;

import com.adgile.user.domain.user.User;
import com.adgile.user.domain.user.UserConditional;
import com.adgile.user.domain.user.UserReader;
import com.adgile.user.domain.user.UserStore;
import com.adgile.user.infrastructure.message.AmazonSqsSender;
import com.adgile.user.presentation.dto.user.UserDto;
import com.adgile.user.presentation.dto.user.UserDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.security.InvalidParameterException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserFacade {

	private final UserReader userReader;
	private final UserStore userStore;
	private final UserDtoMapper userMapper;
	private final AmazonSqsSender sqsSender;

	public void registerUser(UserDto.UserCreateRequest request) {
		// user id 중복 체크

		var where = UserConditional.builder()
				.userId(request.getUserId())
				.build();

		userReader.isValidationUser(where);

		// user 등록 하는 부분
		User user = request.toEntity();
		userStore.store(user);
	}

	// 수정하기
	@Transactional
	public void updateUser(Long id, UserDto.UserUpdateRequest request) {
		// user 등록 되어있는지 체크
		var where = UserConditional.builder()
				.id(id)
				.build();

		var user = this.getUser(where);

		// 수정하기
		user.update(request);

	}

	// 단건 조회
	public UserDto.UserInfoResponse getUserById(Long id) {
		var where = UserConditional.builder()
				.id(id)
				.build();

		var user = this.getUser(where);
		return userMapper.of(user);
	}

	public User getUser(UserConditional where) {

		if (ObjectUtils.isEmpty(where)) {
			throw new InvalidParameterException("");
		}

		var conditional = UserConditional.builder()
				.id(where.getId())
				.userId(where.getUserId())
				.token(where.getToken())
				.build();

		var user = userReader.findUser(conditional);

		return user;
	}

	// 리스트 조회

	// 채팅 보내기
	public void doChat(UserDto.UserChatRequest request) {
		// user 조회

		var where = UserConditional.builder()
				.id(request.getUserId())
				.build();

		this.getUser(where);

		// chat sender
		var chatRequest = new UserDto.SqsChat(request);
		log.info("chatRequest == {}", chatRequest);
		sqsSender.sendMessage(chatRequest);
	}
}
