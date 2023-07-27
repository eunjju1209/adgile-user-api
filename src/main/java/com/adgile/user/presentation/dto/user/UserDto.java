package com.adgile.user.presentation.dto.user;

import com.adgile.user.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserDto {

	@Getter
	@Setter
	@ToString
	public static class UserCreateRequest {
		private String userId;
		private boolean isConnectSns;

		public User toEntity() {
			return User
					.builder()
					.userId(userId)
					.isConnectSns(isConnectSns)
					.build();
		}
	}

	@Getter
	@Setter
	@ToString
	public static class UserUpdateRequest {
		private String userId;
		private Boolean isConnectSns;
	}

	@Getter
	@Builder
	@ToString
	public static class UserInfoResponse {
		private Long id;
		private String token;
		private String userId;
		private Boolean isConnectSns;
	}

}
