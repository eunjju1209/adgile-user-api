package com.adgile.user.domain.user;

public interface UserReader {

	User findUser(UserConditional where);

	void isValidationUser(UserConditional where);
}
