package com.metanet.vacation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_code")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Code {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_id", unique = true)
	private Long codeId;	// �ڵ� �׷�	
	
	@Column(unique = true)
	private String code; // �ڵ�

	@Column(name = "code_group")
	private String codeGroup;	// �ڵ� �׷�
	
	@Column(name = "code_name")
	private String codeName;	
	
	@Column(name = "code_value")
	private String codeValue;
}
