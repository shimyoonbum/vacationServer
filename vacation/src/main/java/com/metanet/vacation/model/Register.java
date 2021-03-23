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
	// �ް���û ����ڵ�
	@Id
	@Column(name = "reg_code")
	private String regCode;
	// ��û���ڵ�
	@Column(name = "apply_emp_code")
	private String applyEmpCode;
	// �������ڵ�
	@Column(name = "confirm_emp_code")
	private String confirmEmpCode;
	// �ް���û��
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
	@Column(name = "reg_date")
	private LocalDateTime regDate;
	// ������
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	@Column(name = "reg_start_date")
	private LocalDateTime regStartDate;
	// ������
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	@Column(name = "reg_end_date")
	private LocalDateTime regEndDate;
	// �ް��ϼ�
	@Column(name = "reg_num")
	private Double regNum;
	// �ް����� �ڵ�
	@Column(name = "vk_code")
	private String vkCode;	
	// ��û ����
	@Column(name = "reg_reason")
	private String regReason;	
	// �ް� ���� ��¥
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
	@Column(name = "confirm_date")
	private String confirmDate;	
	// �ް����� �����ڵ�
	@Column(name = "vs_code")
	private String vsCode;	
	// �ݷ� ����
	@Column(name = "reject_reason")
	private String rejectReason;
}