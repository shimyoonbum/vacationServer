package com.metanet.vacation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import com.metanet.vacation.dto.UserDto;
import com.metanet.vacation.dto.VacationApplyDTO;
import com.metanet.vacation.jwt.JwtTokenProvider;
import com.metanet.vacation.service.ManageService;
import com.metanet.vacation.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/manage")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class ManageController {

	private final ManageService service;

	@GetMapping("/getMember")
	public ResponseEntity<?> getMember() {
		return ResponseEntity.ok(service.getMember());
	}	
	
	//ÈÞ°¡ ¼öÁ¤
	@PutMapping("/doUpdate/{id}")
	public ResponseEntity<?> doUpdate(@RequestBody Map<String, Object> map, @PathVariable Integer id) {	
		Map<String, Integer> res = new HashMap<>(); 	
		int count = 0;
		
		try {
			count = service.update(map, id);
		} catch (Exception e) {		
			res.put("result", 0);
			return ResponseEntity.ok(res);
		}		
		
		res.put("result", count);
		return ResponseEntity.ok(res);
	}
}