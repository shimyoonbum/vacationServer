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
	
	@GetMapping("/getCode")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<?> getCode() {
		return ResponseEntity.ok(userService.getCode().get());
	}
	
//	@GetMapping("/getRegister")
//	@PreAuthorize("hasAnyRole('USER','ADMIN')")
//	public ResponseEntity<?> getRegister() {
//		return ResponseEntity.ok(userService.getRegister().get());
//	}
	
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
	
	@GetMapping("/getMember")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<?> getMember() {
		return ResponseEntity.ok(userService.getMember());
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