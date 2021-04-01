package com.metanet.vacation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metanet.vacation.model.Account;
import com.metanet.vacation.model.Employee;

public interface AccountRepository extends JpaRepository<Account, String> {
	@EntityGraph(attributePaths = "authorities")
	Optional<Account> findOneWithAuthoritiesByUsername(String username);
	
	@Query(value = "select emp_code from tb_account where username = :username", nativeQuery = true)
	String findByUsername(@Param(value = "username") String username);
}