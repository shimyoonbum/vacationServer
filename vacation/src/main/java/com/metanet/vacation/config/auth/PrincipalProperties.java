package com.metanet.vacation.config.auth;

public interface PrincipalProperties {
	String SECRET = "metanet"; // �츮 ������ �˰� �ִ� ��а�
	int EXPIRATION_TIME = 600000; // 10��
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_STRING = "Authorization";
}