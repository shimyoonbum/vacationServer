package com.metanet.vacation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.vacation.model.Account;
import com.metanet.vacation.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {	

	Employee findByEmpCode(String code);

//	@EntityGraph(attributePaths = {"employee", "empCode"})
	List<Employee> findByEmpCodeOrEmpUpper(String code, Employee code2);
}