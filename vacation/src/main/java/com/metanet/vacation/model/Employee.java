package com.metanet.vacation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_employee")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	// 사원 코드
	@Id
	@Column(name = "emp_code")
	private String empCode;
	// 이름
	@Column(name = "emp_name")
	private String empName;
	// 직위
	@Column(name = "emp_rank")
	private String empRank;
	// 조직코드
	@OneToOne
	@JoinColumn(name = "orgCode")
	private Organization orgCode;
	// 성별
	private String gender;
	// 전화번호
	private String phone;
	// 입사일
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "join_date")
	private Date joinDate;
	// 상위자 코드
	@Column(name = "emp_upper")
	private String empUpper;
}