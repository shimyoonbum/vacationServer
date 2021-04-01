package com.metanet.vacation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_employee")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@Column(name = "emp_code", unique = true, nullable = false)
	private String empCode;					// 사원 코드
	
	@Column(name = "emp_name")
	private String empName;					// 이름
	
	@Column(name = "emp_rank")
	private String empRank;					// 직위
	
	private String gender;					// 성별
	
	private String phone;					// 전화번호
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	@Column(name = "join_date")
	private LocalDateTime joinDate;			// 입사일
	
	@Column(name = "emp_upper")
	private String empUpper;				// 상위자 코드
	
	@OneToOne
	@JoinColumn(name = "orgCode")
	private Organization organization;		// 조직코드
	
	@OneToOne(mappedBy = "empCode")
	@JsonIgnoreProperties({"empCode"})
	private Vacation vacation;				// 휴가
	
	@OneToMany(mappedBy = "employee")
	@JsonIgnoreProperties({"employee"})
	private List<Register> register;	// 코드 그룹 조인		
}