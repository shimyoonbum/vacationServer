package com.metanet.vacation.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_vacation_management")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vacation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Id
	@OneToOne
	@JoinColumn(name = "emp_code", unique = true, nullable = false)
	private Employee empCode;				// 사원 코드
	
	private String year;				// 발생연도
	
	@Column(name = "acq_days_num")
	private Double acqDaysNum;			// 발생일수
	
	@Column(name = "use_days_num")
	private Double useDaysNum;			// 사용일수
	
	@Column(name = "res_days_num")
	private Double resDaysNum;			// 잔여일수
	
}