package com.metanet.vacation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.vacation.model.MetanetUser;

public interface UserRepository extends JpaRepository<MetanetUser, Long>{
	MetanetUser findByUsername(String username);
}