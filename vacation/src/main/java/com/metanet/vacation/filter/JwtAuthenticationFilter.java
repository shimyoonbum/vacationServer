package com.metanet.vacation.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metanet.vacation.config.auth.PrincipalDetails;
import com.metanet.vacation.config.auth.PrincipalProperties;
import com.metanet.vacation.model.LoginRequestDto;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	// ������ �� ��ü ��.
	private final AuthenticationManager authenticationManager;

	// login ��û�� �ϸ� �α��� �õ��� ���� �����.
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		// request�� �ִ� username�� password�� �Ľ��ؼ� �ڹ� Object�� �ޱ�
		ObjectMapper om = new ObjectMapper();
		LoginRequestDto loginRequestDto = null;
		try {
			loginRequestDto = om.readValue(request.getInputStream(), LoginRequestDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// id�� pw �޾Ƽ� �α��� �õ���. authenticationManager�� �α��νõ��ϸ�
		// PrincipalDetailsService�� loadUserByUsername�� ����˴ϴ�.
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				loginRequestDto.getUsername(), loginRequestDto.getPassword());

		Authentication authentication = authenticationManager.authenticate(authenticationToken);

		// authentication ��ü�� session ������ �����. �α����� �Ǿ��ٴ� ��.
		PrincipalDetails principalDetailis = (PrincipalDetails) authentication.getPrincipal();
		System.out.println("Authentication ���� : " + principalDetailis.getUser().getUsername());

		return authentication;
	}

	// ���� �Ϸ� �Ǹ� JWT ��ū�� ���� ����ڿ��� JWT ��ū�� response �ϸ� �˴ϴ�.
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		PrincipalDetails principalDetailis = (PrincipalDetails) authResult.getPrincipal();
		
		String jwtToken = JWT.create()
				.withSubject(principalDetailis.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+PrincipalProperties.EXPIRATION_TIME))
				.withClaim("id", principalDetailis.getUser().getId())
				.withClaim("username", principalDetailis.getUser().getUsername())
				.sign(Algorithm.HMAC512(PrincipalProperties.SECRET));
		
		response.addHeader(PrincipalProperties.HEADER_STRING, PrincipalProperties.TOKEN_PREFIX+jwtToken);

	}
}
