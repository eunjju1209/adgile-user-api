package com.adgile.user.domain.user;

import com.adgile.user.common.BaseTimeEntity;
import com.adgile.user.common.TokenGenerator;
import com.adgile.user.domain.sns.Sns;
import com.adgile.user.presentation.dto.user.UserDto;
import com.google.common.collect.Lists;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class User extends BaseTimeEntity {

	private static final String PREFIX = "user";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String token;

	private String userId;

	private Boolean isConnectSns;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<Sns> snsList = Lists.newArrayList();

	public void update(UserDto.UserUpdateRequest request) {
		this.userId = request.getUserId();
		this.isConnectSns = request.getIsConnectSns();
	}


	@Builder
	public User(Long id, String userId, Boolean isConnectSns) {
		if (StringUtils.isEmpty(userId)) throw new InvalidParameterException("user id is required");
		if (isConnectSns == null) isConnectSns = Boolean.FALSE;
		this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX);
		this.userId = userId;
		this.isConnectSns = isConnectSns;
	}

}
