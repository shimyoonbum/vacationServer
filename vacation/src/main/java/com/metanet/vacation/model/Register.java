package com.metanet.vacation.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_vacation_apply")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Register {
	// 휴가신청 목록코드
	@Id
	@Column(name = "reg_code")
	private String regCode;
	// 신청자코드
	@Column(name = "apply_emp_code")
	private String applyEmpCode;
	// 승인자코드
	@Column(name = "confirm_emp_code")
	private String confirmEmpCode;
	// 휴가신청일
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
	@Column(name = "reg_date")
	private LocalDateTime regDate;
	// 시작일
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	@Column(name = "reg_start_date")
	private LocalDateTime regStartDate;
	// 종료일
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	@Column(name = "reg_end_date")
	private LocalDateTime regEndDate;
	// 휴가일수
	@Column(name = "reg_num")
	private Double regNum;
	// 휴가유형 코드
	@Column(name = "vk_code")
	private String vkCode;	
	// 신청 사유
	@Column(name = "reg_reason")
	private String regReason;	
	// 휴가 승인 날짜
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
	@Column(name = "confirm_date")
	private String confirmDate;	
	// 휴가승인 상태코드
	@Column(name = "vs_code")
	private String vsCode;	
	// 반려 사유
	@Column(name = "reject_reason")
	private String rejectReason;
}