package com.metanet.vacation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metanet.vacation.dto.UserDto;
import com.metanet.vacation.dto.VacationApplyDTO;
import com.metanet.vacation.exception.BadRequestException;
import com.metanet.vacation.jwt.JwtTokenProvider;
import com.metanet.vacation.model.Account;
import com.metanet.vacation.model.Authority;
import com.metanet.vacation.model.Code;
import com.metanet.vacation.model.Employee;
import com.metanet.vacation.model.Register;
import com.metanet.vacation.model.Vacation;
import com.metanet.vacation.repository.AccountRepository;
import com.metanet.vacation.repository.CodeRepository;
import com.metanet.vacation.repository.EmployeeRepository;
import com.metanet.vacation.repository.RegisterRepository;
import com.metanet.vacation.repository.VacationRepository;
import com.metanet.vacation.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManageService {
    private final AccountRepository accountRepository;
    private final EmployeeRepository employeeRepository;
    private final RegisterRepository registerRepository;
    private final VacationRepository vacationRepository;

    private static final Logger logger = LoggerFactory.getLogger(ManageService.class);
        
    @Transactional(readOnly = true)
	public Map<String, Object> getMember() {
    	
		Map<String, Object> member = new HashMap<>();
		
		String username = SecurityUtil.getCurrentUsername().get();
		String code = accountRepository.findByUsername(username);
		Employee codeUpper = employeeRepository.findByEmpCode(code);
		
//		List<Map<String, Object>> auth = ;
//		logger.info(auth.toString());
//		List<Employee> emp = ;
		
		member.put("authorities", accountRepository.findAuthoritiesByUsername(username));
		member.put("emp", employeeRepository.findByEmpCodeOrEmpUpper(code, codeUpper));
				
		return member;
	}
    
    //휴가 승인/거절 처리
	@Transactional
	public int update(Map<String, Object> map, Integer id) throws BadRequestException{
		Optional<Register> r = registerRepository.findById(id);
		//휴가 승인시 휴가 승인 처리 및 승인 처리자 select
		String username = SecurityUtil.getCurrentUsername().get();
		String code = accountRepository.findByUsername(username);	
		
		r.ifPresent(updReg -> {
			updReg.setConfirmDate(LocalDateTime.now());
			updReg.setConfirmEmpCode(code);
			updReg.setRejectReason(map.get("reason").toString());
			updReg.setVsCode(map.get("vsCode").toString());
		});		
		
		if(map.get("vsCode").toString().equals("VS3"))
			return 1;
		//휴가 승인시에 날짜 삭감 처리하기 위한 로직
		Employee codeVacation = employeeRepository.findByEmpCode(map.get("empCode").toString());
		
		Optional<Vacation> v = vacationRepository.findByEmpCode(codeVacation); 
		 
		v.ifPresent(updReg -> {

			Double d = Double.parseDouble(map.get("regNum").toString());		
			
			if(updReg.getResDaysNum()-d < 0)
				throw new BadRequestException(HttpStatus.BAD_REQUEST, "사용 가능 연차 수 초과");
			
			updReg.setResDaysNum(updReg.getResDaysNum()-d);
			updReg.setUseDaysNum(updReg.getUseDaysNum()+d);
		});		
		
		return 1;
	}  	
}