package com.metanet.vacation.model;

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
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_account")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	//아이디 코드
	@JsonIgnore
	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	private String Id;

	@Column(name = "username", length = 50)
	private String username;

	@JsonIgnore
	@Column(name = "password", length = 100)
	private String password;

	@JsonIgnore
	@Column(name = "activated")
	private boolean activated;
	
	@OneToOne
	@JoinColumn(name = "empCode")
	private Employee empCode;

	@ManyToMany
	@JoinTable(name = "user_authority", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = {
					@JoinColumn(name = "authority_name", referencedColumnName = "authority_name") })
	private Set<Authority> authorities;

}
