package com.metanet.vacation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import com.metanet.vacation.dto.UserDto;
import com.metanet.vacation.jwt.JwtTokenProvider;
import com.metanet.vacation.service.ManageService;
import com.metanet.vacation.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/manage")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class ManageController {

	private final UserService service;

	@GetMapping("/getMember")
	public ResponseEntity<?> getMember() {
		return ResponseEntity.ok(service.getMember());
	}	
}