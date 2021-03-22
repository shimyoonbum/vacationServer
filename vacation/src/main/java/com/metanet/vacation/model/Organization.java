package com.metanet.vacation.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_organization")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

	@JsonIgnore
	@Id
	@Column(name = "org_code", length = 50)
	private String orgCode;

	@Column(name = "org_name", length = 50)
	private String orgName;

	@Column(name = "org_div", length = 50)
	private String orgDiv;

	@Column(name = "org_upper", length = 50)
	private String orgUpper;
}