package com.metanet.vacation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.vacation.dto.UserDto;
import com.metanet.vacation.dto.VacationApplyDTO;
import com.metanet.vacation.model.Register;
import com.metanet.vacation.service.UserService;
import com.metanet.vacation.service.VacationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vacation")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class VacationController {	

    private static final Logger logger = LoggerFactory.getLogger(VacationController.class);

	private final VacationService service;	
	
	//�ް� ���
	@PostMapping("/doApply")
	public ResponseEntity<?> doApply(@RequestBody VacationApplyDTO dto) {		
		Register result = service.apply(dto);
		
		return ResponseEntity.ok(result);
	}
	
	//�ް� ����
	@PutMapping("/doUpdate/{id}")
	public ResponseEntity<?> doUpdate(@RequestBody VacationApplyDTO dto, @PathVariable Integer id) {	
		Map<String, Integer> res = new HashMap<>(); 	
		int count = 0;
		
		try {
			count = service.update(dto, id);
		} catch (Exception e) {		
			res.put("result", 0);
			return ResponseEntity.ok(res);
		}		
		
		res.put("result", count);
		return ResponseEntity.ok(res);
	}
	
	//�ϰ� ����
	@DeleteMapping("/deleteReg")
	public ResponseEntity<?> deleteReg(@RequestBody Map<String, Object> list) throws Exception{
		int count = service.deleteById(list);
		
		Map<String, Integer> res = new HashMap<>(); 
		res.put("result", count);
		return ResponseEntity.ok(res);
	}

	//���� ����
	@DeleteMapping("/deleteReg/{id}")
	public ResponseEntity<?> deleteOneReg(@PathVariable Integer id) throws Exception{		
		boolean res = service.deleteById(id);
		
		if(!res) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
