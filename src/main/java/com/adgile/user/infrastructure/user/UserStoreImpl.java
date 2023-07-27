package com.adgile.user.infrastructure.user;

import com.adgile.user.domain.user.User;
import com.adgile.user.domain.user.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {

	private final UserRepository userRepository;

	@Override
	public void store(User user) {
		userRepository.save(user);
	}
}
