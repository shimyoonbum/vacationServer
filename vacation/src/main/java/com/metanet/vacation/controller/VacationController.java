package com.metanet.vacation.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.vacation.dto.UserDto;
import com.metanet.vacation.service.UserService;
import com.metanet.vacation.service.VacationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vacation")
@RequiredArgsConstructor
public class VacationController {	

    private static final Logger logger = LoggerFactory.getLogger(VacationController.class);

	private final VacationService service;
	
	@DeleteMapping("/deleteReg")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<?> deleteReg(@RequestBody Map<String, Object> list) throws Exception{
		logger.info(list.toString());
		service.deleteById(list);
		return ResponseEntity.ok("Success");
	}
}
