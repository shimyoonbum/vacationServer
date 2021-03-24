package com.metanet.vacation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.vacation.model.Account;
import com.metanet.vacation.model.Code;
import com.metanet.vacation.model.Employee;

public interface CodeRepository extends JpaRepository<Code, String> {
	Optional<Code> findByCode(String code);
}