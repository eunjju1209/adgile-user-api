package com.adgile.user.domain.user;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserConditional {

	private Long id;
	private String token;
	private String userId;
	private Boolean isConnectSns;

	@Builder
	public UserConditional(Long id, String token, String userId, Boolean isConnectSns) {
		this.id = id;
		this.token = token;
		this.userId = userId;
		this.isConnectSns = isConnectSns;
	}
}
