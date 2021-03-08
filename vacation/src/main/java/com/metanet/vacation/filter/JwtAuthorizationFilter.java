package com.metanet.vacation.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.metanet.vacation.config.auth.PrincipalDetails;
import com.metanet.vacation.config.auth.PrincipalProperties;
import com.metanet.vacation.model.MetanetUser;
import com.metanet.vacation.repository.UserRepository;

//�ΰ�
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

	private UserRepository userRepository;

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
		super(authenticationManager);
		this.userRepository = userRepository;
	}

	// ���͸� �ɾ��ش�.
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader(PrincipalProperties.HEADER_STRING);
		if (header == null || !header.startsWith(PrincipalProperties.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		System.out.println("header : " + header);
		String token = request.getHeader(PrincipalProperties.HEADER_STRING)
				.replace(PrincipalProperties.TOKEN_PREFIX, "");

		// ��ū ���� (�̰� �����̱� ������ AuthenticationManager�� �ʿ� ����)
		// ���� SecurityContext�� ���������ؼ� ������ ���鶧 �ڵ����� UserDetailsService�� �ִ�
		// loadByUsername�� ȣ���.
		String username = JWT.require(Algorithm.HMAC512(PrincipalProperties.SECRET)).build().verify(token)
				.getClaim("username").asString();

		if (username != null) {
			MetanetUser user = userRepository.findByUsername(username);

			// ������ ��ū ������ ��. ������ �ϱ� ���ؼ��� �ƴ� ������ ��ť��Ƽ�� �������ִ� ���� ó���� ����
			// �Ʒ��� ���� ��ū�� ���� Authentication ��ü�� ������ ����� �װ� ���ǿ� ����!
			PrincipalDetails principalDetails = new PrincipalDetails(user);
			Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails,
					null, // �н������ �𸣴ϱ� null ó��, ������ ���� �����ϴ°� �ƴϴϱ�!!
					principalDetails.getAuthorities());

			// ������ ��ť��Ƽ�� ���ǿ� �����Ͽ� �� ����
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}

		chain.doFilter(request, response);
	}

}