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
	private String empCode;					// ��� �ڵ�
	
	@Column(name = "emp_name")
	private String empName;					// �̸�
	
	@Column(name = "emp_rank")
	private String empRank;					// ����
	
	private String gender;					// ����
	
	private String phone;					// ��ȭ��ȣ
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	@Column(name = "join_date")
	private LocalDateTime joinDate;			// �Ի���
	
	@Column(name = "emp_upper")
	private String empUpper;				// ������ �ڵ�
	
	@OneToOne
	@JoinColumn(name = "orgCode")
	private Organization organization;		// �����ڵ�
	
	@OneToOne(mappedBy = "empCode")
	@JsonIgnoreProperties({"empCode"})
	private Vacation vacation;				// �ް�
	
	@OneToMany(mappedBy = "employee")
	@JsonIgnoreProperties({"employee"})
	private List<Register> register;	// �ڵ� �׷� ����		
}