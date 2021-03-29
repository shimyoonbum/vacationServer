package com.metanet.vacation.model;

import java.time.LocalDateTime;

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
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_vacation_apply")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reg_id", unique = true, nullable = false)
	private Long id; 					// �ް���û ����ڵ�

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	@Column(name = "reg_date")
	private LocalDateTime regDate;		// �ް���û��

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@Column(name = "reg_start_date")
	private LocalDateTime regStartDate;	// ������

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@Column(name = "reg_end_date")
	private LocalDateTime regEndDate;	// ������

	@Column(name = "reg_num")
	private Double regNum;				// �ް��ϼ�
	
	@Column(name = "reg_reason")
	private String regReason; 			// ��û ����	
		
	@Column(name = "confirm_emp_code")
	private String confirmEmpCode;		// �������ڵ�	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	@Column(name = "confirm_date")
	private LocalDateTime confirmDate;			// �ް� ���� ��¥

	@Column(name = "reject_reason")
	private String rejectReason;		// �ݷ� ����	
	
	@OneToOne
	@JoinColumn(name = "code")
	private Code vkCode; 				// �ް����� �ڵ�	

	@Column(name = "vs_code")
	private String vsCode;				// �ް����� �����ڵ�

	@ManyToOne
	@JoinColumn(name = "emp_code")
	private Employee employee; // �ڵ� �׷� ����
}