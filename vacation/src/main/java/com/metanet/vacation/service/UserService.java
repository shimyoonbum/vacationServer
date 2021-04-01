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
public class UserService {
    private final AccountRepository accountRepository;
    private final EmployeeRepository employeeRepository;
    private final CodeRepository codeRepository;
    private final RegisterRepository registerRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    @Transactional
    public Account signup(UserDto userDto) {
        if (accountRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        //빌더 패턴의 장점
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        Account user = Account.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return accountRepository.save(user);
    }

//    @Transactional(readOnly = true)
//    public Optional<Account> getUserWithAuthorities(String username) {
//        return accountRepository.findOneWithAuthoritiesByUsername(username);
//    }

    @Transactional(readOnly = true)
    public Optional<Account> getMyUserWithAuthorities() {
    	return SecurityUtil.getCurrentUsername().flatMap(accountRepository::findOneWithAuthoritiesByUsername);
    }
    
//    @Transactional(readOnly = true)
//	public List<Account> getUserInfo() {
//    	return accountRepository.findAll();
//	}
//    
//    @Transactional(readOnly = true)
//	public Optional<Code> getCode() {		
//		return codeRepository.findByCode("VK1");
//	}
    
//    @Transactional(readOnly = true)
//	public Optional<Register> getRegister() {
//		return registerRepository.findByApplyEmpCode("E0013");
//	}
    
    @Transactional(readOnly = true)
	public Employee getEmpInfo() {		
		return employeeRepository.findByEmpCode("E0013");
	}

	@Transactional(readOnly = true)
	public List<Employee> getMember() {
		String username = SecurityUtil.getCurrentUsername().get();
		String code = accountRepository.findByUsername(username);
    	
		return employeeRepository.findByEmpCodeOrEmpUpper(code, code);
	}
}