package com.metanet.vacation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.metanet.vacation.filter.CorsOriginFilter;
import com.metanet.vacation.filter.JwtAuthenticationFilter;
import com.metanet.vacation.filter.JwtAuthorizationFilter;
import com.metanet.vacation.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CorsOriginFilter corsConfig;
	
	@Autowired
	private UserRepository userRepository;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.cors().disable()
			.csrf().disable()
			// �� �α��� â ������ �ʵ��� ����
			.formLogin().disable()
			//HEADER�� ID�� PW�� �ް� ������ ��ŵǴ� ���(���⿡ ���) Bearer jwt ��ū ����� ������.
			.httpBasic().disable()	
			.headers().frameOptions().disable()
			.and()
			.addFilter(corsConfig.corsFilter())
			.addFilter(new JwtAuthenticationFilter(authenticationManager()))
			.addFilter(new JwtAuthorizationFilter(authenticationManager(), userRepository))
			// ���� ���� ���� ��� x(getSession�� ����)
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}