package com.metanet.vacation.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_vacation_apply")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reg_id", unique = true, nullable = false)
	private Integer id; 					// 휴가신청 목록코드

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	@Column(name = "reg_date")
	private LocalDateTime regDate;		// 휴가신청일

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@Column(name = "reg_start_date")
	private LocalDate regStartDate;	// 시작일

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@Column(name = "reg_end_date")
	private LocalDate regEndDate;	// 종료일

	@Column(name = "reg_num")
	private Double regNum;				// 휴가일수
	
	@Column(name = "reg_reason")
	private String regReason; 			// 신청 사유	
		
	@Column(name = "confirm_emp_code")
	private String confirmEmpCode;		// 승인자코드	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	@Column(name = "confirm_date")
	private LocalDateTime confirmDate;			// 휴가 승인 날짜

	@Column(name = "reject_reason")
	private String rejectReason;		// 반려 사유	
	
	@OneToOne
	@JoinColumn(name = "code")
	private Code vkCode; 				// 휴가유형 코드	

	@Column(name = "vs_code")
	private String vsCode;				// 휴가승인 상태코드

	@ManyToOne
	@JoinColumn(name = "emp_code")
	private Employee employee; // 코드 그룹 조인
}