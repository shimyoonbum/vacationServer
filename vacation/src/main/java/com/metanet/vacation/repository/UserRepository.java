package com.metanet.vacation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.vacation.model.Account;

public interface UserRepository extends JpaRepository<Account, String> {
	@EntityGraph(attributePaths = "authorities")
	Optional<Account> findOneWithAuthoritiesByUsername(String username);
}