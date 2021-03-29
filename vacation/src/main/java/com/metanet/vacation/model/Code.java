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
//@JsonIdentityInfo(generator = IntSequenceGenerator.class, property = "id") // 추가
public class Code {

	@Id	
	private String code; // 코드

	@OneToOne
	@JoinColumn(name = "groupCode")
	private CodeGroup codeGroup; // 코드 그룹 조인
	
	@Column(name = "code_name")
	private String codeName;	//코드이름
	
	@Column(name = "code_value")
	private String codeValue;	//코드값

//	@ManyToOne
//	@JoinColumn(name = "code_group")
//	private CodeGroup codeGroup; // 코드 그룹 조인
}
