package com.adgile.user.domain.sns;

import com.adgile.user.common.BaseTimeEntity;
import com.adgile.user.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Sns extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	private Long userId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String token;

	@Enumerated(EnumType.STRING)
	private Type type;

	@Getter
	@RequiredArgsConstructor
	public enum Type {
		GOOGLE, FACEBOOK, TWITTER
	}

}
