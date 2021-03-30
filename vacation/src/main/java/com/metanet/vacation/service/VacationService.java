package com.metanet.vacation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metanet.vacation.dto.UserDto;
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
public class VacationService {
    private final RegisterRepository registerRepository;
    private final EmployeeRepository employeeRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(VacationService.class);
        
    @Transactional
	public int deleteById(Map<String, Object> list) {
    	int count = 0;
    	
    	List<Integer> obj = (List<Integer>) list.get("ids");    
    	String empCode = list.get("code").toString();   
    	
    	for(Integer o : obj) { 
    		int a = registerRepository.deleteById(o, empCode);
    		count += a;    		
    	}
    	
    	return count;
	}
    
	@Transactional
	public boolean deleteById(Integer id) throws Exception{
		try {
			registerRepository.deleteById(id);				
		}catch(Exception e) {
			return false;
		}
		
		return true;		
	}
}