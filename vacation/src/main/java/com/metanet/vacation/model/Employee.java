package com.metanet.vacation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;
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
	// ��� �ڵ�
	@Id
	@Column(name = "emp_code")
	private String empCode;
	// �̸�
	@Column(name = "emp_name")
	private String empName;
	// ����
	@Column(name = "emp_rank")
	private String empRank;
	// ����
	private String gender;
	// ��ȭ��ȣ
	private String phone;
	// �Ի���
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	@Column(name = "join_date")
	private LocalDateTime joinDate;
	// ������ �ڵ�
	@Column(name = "emp_upper")
	private String empUpper;	
	// �����ڵ�
	@OneToOne
	@JoinColumn(name = "orgCode")
	private Organization organization;	
	// �ް�
	@OneToOne
	@JoinColumn(name = "empCode")
	private Vacation vacation;	
}