package com.metanet.vacation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import com.metanet.vacation.dto.UserDto;
import com.metanet.vacation.jwt.JwtTokenProvider;
import com.metanet.vacation.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;

	@GetMapping("/hello")
	public ResponseEntity<?> hello() {
		return ResponseEntity.ok("hello");
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody UserDto userDto) {
		return ResponseEntity.ok(userService.signup(userDto));
	}
	
	@GetMapping("/get")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<?> getUserInfo() {
		return ResponseEntity.ok(userService.getUserInfo());
	}
	

	@GetMapping("/user")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<?> getMyUserInfo() {
		return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
	}

	@GetMapping("/user/{username}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> getUserInfo(@PathVariable String username) {
		return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
	}
}