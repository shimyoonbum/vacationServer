package com.metanet.vacation.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.*;

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
public class CodeGroup {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id", unique = true)
	private Long groupId;	// 코드 그룹
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "code_group")
	private Set<Code> code;	// 코드 그룹	
	
	@Column(name = "group_code")
	private String groupCode;	
	
	@Column(name = "group_name")
	private String groupName;	
}