package com.metanet.vacation.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_account")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	@JsonIgnore
	@Id
	@Column(name = "user_id", nullable = false)
	private String id; // 아이디 코드

	@Column(name = "username", length = 50)
	private String username;

	@JsonIgnore
	@Column(name = "password", length = 100)
	private String password;

	@JsonIgnore
	@Column(name = "activated")
	private boolean activated;// 활성 여부

	@OneToOne
	@JoinColumn(name = "empCode")
	private Employee employee;// 사원 조인 컬럼

	@ManyToMany
	@JoinTable(name = "tb_account_authority",
			joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "authority_name", referencedColumnName = "authority_name") })
	private Set<Authority> authorities;

}
