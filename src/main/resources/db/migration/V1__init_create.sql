# -- user
create table user
(
    id bigint auto_increment primary key comment 'id',
    token varchar(255) not null comment 'token',
    user_id varchar(255) not null comment 'user의 id',
    is_connect_sns tinyint(1) default 0 comment 'sns 연결 여부',
    created_at    datetime(6) not null comment '생성 일시',
    updated_at    datetime(6) null comment '수정 일시',
    deleted_at datetime(6) null comment '삭제 일시'
);

-- sns
create table sns
(
    id bigint auto_increment primary key comment 'id',
    token varchar(255) not null comment 'token',
    type varchar(25) not null comment 'sns 종류',
    created_at    datetime(6) not null comment '생성 일시',
    updated_at    datetime(6) null comment '수정 일시',
    deleted_at datetime(6) null comment '삭제 일시'
)