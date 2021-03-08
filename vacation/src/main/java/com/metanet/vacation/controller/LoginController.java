package com.metanet.vacation.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.vacation.model.MetanetUser;
import com.metanet.vacation.model.Role;
import com.metanet.vacation.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoginController {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("home")
	public String home() {
		return "<h1>gome</h1>";
	}
	
	//postMan 으로 회원 등록 합니다.
	@PostMapping("join")
	public String join(@RequestBody MetanetUser user) throws Exception {
		try {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setRole("USER");
			userRepository.save(user);

			return "회원가입완료";
		} catch (Exception e) {}
		
		return null;
	}
}
