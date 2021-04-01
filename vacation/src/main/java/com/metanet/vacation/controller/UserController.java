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

	//ȸ�� ���
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody UserDto userDto) {
		return ResponseEntity.ok(userService.signup(userDto));
	}
	
	/*
	@GetMapping("/getCode")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<?> getCode() {
		return ResponseEntity.ok(userService.getCode().get());
	}
	
	@GetMapping("/getUserInfo")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<?> getUserInfo() {
		return ResponseEntity.ok(userService.getUserInfo());
	}
	
	@GetMapping("/getEmpInfo")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<?> getEmpInfo() {
		return ResponseEntity.ok(userService.getEmpInfo());
	}
	*/

	@GetMapping("/user")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<?> getMyUserInfo() {
		return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
	}
}