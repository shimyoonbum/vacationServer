package com.metanet.vacation.config.auth;

public interface PrincipalProperties {
	String SECRET = "metanet"; // 우리 서버만 알고 있는 비밀값
	int EXPIRATION_TIME = 600000; // 10분
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_STRING = "Authorization";
}