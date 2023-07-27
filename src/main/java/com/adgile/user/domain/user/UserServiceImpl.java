package com.adgile.user.domain.user;

import com.adgile.user.infrastructure.user.UserRepository;
import com.adgile.user.presentation.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	@Transactional
	public void registerUser(User user) {
		userRepository.save(user);
	}

	@Transactional(readOnly = true)
	public UserDto.UserInfoResponse getUserById(Long id) {
		var where = UserConditional.builder()
				.id(id)
				.build();

		return null;

	}
}
