package com.metanet.vacation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.vacation.model.Account;
import com.metanet.vacation.model.Code;
import com.metanet.vacation.model.Employee;
import com.metanet.vacation.model.Vacation;

public interface VacationRepository extends JpaRepository<Vacation, Employee> {

	Optional<Vacation> findByEmpCode(Employee codeVacation);
	
}