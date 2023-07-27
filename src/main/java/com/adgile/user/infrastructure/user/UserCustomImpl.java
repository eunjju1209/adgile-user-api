package com.adgile.user.infrastructure.user;

import com.adgile.user.domain.user.User;
import com.adgile.user.domain.user.UserConditional;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

import static com.adgile.user.domain.user.QUser.user;


@RequiredArgsConstructor
public class UserCustomImpl implements UserCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public Optional<User> findUser(UserConditional where) {
		return Optional.ofNullable(
				queryFactory
						.selectFrom(user)
						.where(
								eqId(where.getId()),
								eqToken(where.getToken()),
								eqUserId(where.getUserId()),
								eqConnectSns(where.getIsConnectSns())
						      )
						.fetchOne()
                      );
	}

	private BooleanExpression eqId(Long id) {
		return id != null ? user.id.eq(id) : null;
	}

	private BooleanExpression eqToken(String token) {
		return !StringUtils.isEmpty(token) ? user.token.eq(token) : null;
	}

	private BooleanExpression eqUserId(String id) {
		return !StringUtils.isEmpty(id) ? user.userId.eq(id) : null;
	}

	private BooleanExpression eqConnectSns(Boolean isConnectSns) {
		return isConnectSns != null ? user.isConnectSns.eq(isConnectSns) : null;
	}
}
