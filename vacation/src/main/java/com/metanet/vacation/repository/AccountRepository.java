package com.metanet.vacation.repository;

import java.util.List;
import java.util.Map;
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
	
	//신청자 목록 화면 조회시에 접속 유저 권한을 SELECT하는 쿼리
	@Query(value = "select b.authority_name authorityName \r\n" + 
			"from tb_account a \r\n" + 
			"left outer join tb_account_authority b on a.user_id=b.user_id\r\n" + 
			"where username = :username", nativeQuery = true)
	List<Map<String, Object>> findAuthoritiesByUsername(@Param(value = "username") String username);
	
	@Query(value = "select emp_code from tb_account where username = :username", nativeQuery = true)
	String findByUsername(@Param(value = "username") String username);
}