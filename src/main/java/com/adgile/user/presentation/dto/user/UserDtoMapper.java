package com.adgile.user.presentation.dto.user;

import com.adgile.user.domain.user.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.CONSTRUCTOR,
		unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserDtoMapper {

	UserDto.UserInfoResponse of(User user);
}
