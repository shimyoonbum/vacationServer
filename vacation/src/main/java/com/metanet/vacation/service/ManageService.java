package com.metanet.vacation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metanet.vacation.dto.UserDto;
import com.metanet.vacation.dto.VacationApplyDTO;
import com.metanet.vacation.jwt.JwtTokenProvider;
import com.metanet.vacation.model.Account;
import com.metanet.vacation.model.Authority;
import com.metanet.vacation.model.Code;
import com.metanet.vacation.model.Employee;
import com.metanet.vacation.model.Register;
import com.metanet.vacation.repository.AccountRepository;
import com.metanet.vacation.repository.CodeRepository;
import com.metanet.vacation.repository.EmployeeRepository;
import com.metanet.vacation.repository.RegisterRepository;
import com.metanet.vacation.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManageService {
    private final AccountRepository accountRepository;
    private final EmployeeRepository employeeRepository;
    private final RegisterRepository registerRepository;

    private static final Logger logger = LoggerFactory.getLogger(ManageService.class);
        
    @Transactional(readOnly = true)
	public List<Employee> getMember() {
		String username = SecurityUtil.getCurrentUsername().get();
		String code = accountRepository.findByUsername(username);
		Employee codeUpper = employeeRepository.findByEmpCode(code);
    	
		return employeeRepository.findByEmpCodeOrEmpUpper(code, codeUpper);
	}
    
    //휴가 승인/거절 처리
	@Transactional
	public int update(Map<String, Object> map, Integer id) throws Exception{
		Optional<Register> r = registerRepository.findById(id);
		//수정 일자가 -1일 씩 까이는 문제가 있어서 1일을 더해줌.
		
		logger.debug(r.get().toString());
		r.ifPresent(updReg -> {
				
		});		

		return 1;
	}    
}