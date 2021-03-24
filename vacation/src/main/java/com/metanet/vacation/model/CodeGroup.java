package com.metanet.vacation.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_code_group")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = IntSequenceGenerator.class, property = "id") // �߰�
public class CodeGroup {

	@JsonIgnore
	@Id	
	@Column(name = "group_code", unique = true, nullable = false)
	private String groupCode;	// �׷��ڵ� 		
	
	@Column(name = "group_name")
	private String groupName;	// �׷��ڵ� �̸�
	
//	@OneToMany(mappedBy = "codeGroup")
//	@JsonIgnoreProperties({"codeGroup"})
//	private List<Code> code;	// �ڵ� �׷� ����			
}