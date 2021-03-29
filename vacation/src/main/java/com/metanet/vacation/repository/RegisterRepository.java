package com.metanet.vacation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metanet.vacation.model.Account;
import com.metanet.vacation.model.Code;
import com.metanet.vacation.model.Employee;
import com.metanet.vacation.model.Register;

public interface RegisterRepository extends JpaRepository<Register, Integer> {
	@Modifying
	@Query(value = "delete from tb_vacation_apply where reg_id = :id and emp_code = :code ", nativeQuery = true)
	int deleteById(@Param(value = "id") Integer id, @Param(value = "code") String code);
//	Optional<Register> findByEmpCode(String code);
}