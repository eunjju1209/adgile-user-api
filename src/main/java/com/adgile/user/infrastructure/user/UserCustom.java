package com.adgile.user.infrastructure.user;

import com.adgile.user.domain.user.User;
import com.adgile.user.domain.user.UserConditional;

import java.util.Optional;

public interface UserCustom {
	Optional<User> findUser(UserConditional where);

}
