package com.metanet.vacation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VacationService {
	private final RegisterRepository registerRepository;
	private final EmployeeRepository employeeRepository;
	private final CodeRepository codeRepository;

	private static final Logger logger = LoggerFactory.getLogger(VacationService.class);

	// 일괄 삭제
	@Transactional
	public int deleteById(Map<String, Object> list) {
		int count = 0;

		List<Integer> obj = (List<Integer>) list.get("ids");
		String empCode = list.get("code").toString();

		// deleteInBatch를 활용하여 where reg_id=? or reg_id=? or reg_id=? 와 같이 일괄 삭제가 가능하다.
		// registerRepository.deleteInBatch(registerRepository.findAllById(Lists.newArrayList(obj)));

		for (Integer o : obj) {
			int a = registerRepository.deleteById(o, empCode);
			count += a;
		}

		return count;
	}

	// 개별 삭제
	@Transactional
	public boolean deleteById(Integer id) throws Exception {
		try {
			registerRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	// 휴가 등록
	@Transactional
	public Register apply(VacationApplyDTO dto) {

		Register r = Register.builder()
				.regDate(LocalDateTime.now())
				.regReason(dto.getRegReason())
				.regNum(dto.getRegNum())
				.regEndDate(dto.getRegEndDate())
				.regStartDate(dto.getRegStartDate())
				.vkCode(codeRepository.findByCode(dto.getCode()).get())
				.vsCode("VS1")
				.employee(employeeRepository.findByEmpCode(dto.getEmpCode()))
				.build();

		return registerRepository.save(r);
	}
	
	// 휴가 수정
	@Transactional
	public int update(VacationApplyDTO dto, Integer id) throws Exception{
		Optional<Register> r = registerRepository.findById(id);
		//수정 일자가 -1일 씩 까이는 문제가 있어서 1일을 더해줌.
		r.ifPresent(updReg -> {
				updReg.setRegStartDate(dto.getRegStartDate().plusDays(1));
				updReg.setRegEndDate(dto.getRegEndDate().plusDays(1));
				updReg.setRegReason(dto.getRegReason());
				updReg.setRegNum(dto.getRegNum());
				updReg.setVkCode(codeRepository.findByCode(dto.getCode()).get());
		});		

		return 1;
	}
}