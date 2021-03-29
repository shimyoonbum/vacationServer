package com.metanet.vacation.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import lombok.*;

@Entity
@Table(name = "tb_code")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = IntSequenceGenerator.class, property = "id") // �߰�
public class Code {

	@Id	
	private String code; // �ڵ�

	@OneToOne
	@JoinColumn(name = "groupCode")
	private CodeGroup codeGroup; // �ڵ� �׷� ����
	
	@Column(name = "code_name")
	private String codeName;	//�ڵ��̸�
	
	@Column(name = "code_value")
	private String codeValue;	//�ڵ尪

//	@ManyToOne
//	@JoinColumn(name = "code_group")
//	private CodeGroup codeGroup; // �ڵ� �׷� ����
}
