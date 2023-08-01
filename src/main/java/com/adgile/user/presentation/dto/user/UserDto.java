package com.adgile.user.presentation.dto.user;

import com.adgile.user.domain.user.User;
import lombok.*;

import java.time.ZonedDateTime;

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
	@Setter
	@ToString
	public static class UserChatRequest {
		private Long userId;
		private Long companyId;
		private String message;
	}

	@Getter
	@ToString
	public static class SqsChat {
		private Long userId;
		private Long companyId;
		private String message;
		private ZonedDateTime createdAt;

		public SqsChat(UserChatRequest request) {
			this.userId = request.getUserId();
			this.companyId = request.getCompanyId();
			this.message = request.getMessage();
			this.createdAt = ZonedDateTime.now();
		}
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
