package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Short>, JpaSpecificationExecutor<Account> {

	Account findByUserName(String username);

	Account findByEmail(String email);

	List<Account> findByFullName(String username);

//	List<Account> findAllOrderByIdDesc();	
}
