package com.metanet.vacation.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_vacation_management")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vacation {
	// 사원 코드
	@JsonIgnore
	@Id
	@Column(name = "emp_code")
	private String empCode;
	// 발생연도
	private String year;
	// 발생일수
	@Column(name = "acq_days_num")
	private Double acqDaysNum;
	// 사용일수
	@Column(name = "use_days_num")
	private Double useDaysNum;
	// 잔여일수
	@Column(name = "res_days_num")
	private Double resDaysNum;	
	
}