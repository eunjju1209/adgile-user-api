package com.adgile.user.infrastructure.user;

import com.adgile.user.domain.user.User;
import com.adgile.user.domain.user.UserConditional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, UserCustom {

	Optional<User> findUser(UserConditional where);
}
