package com.vti.service.IService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Account;

public interface IAccountService extends UserDetailsService {

	Page<Account> getAllAccount(Pageable pageable, String search);

	Account getAllAccountByID(short id);

	Account getAccountByUsername(String name);

	void deleteAccountByID(Short id);

	void createAccout(Account account);

	List<Account> findByFullName(String name);

	boolean checkEmail(String email);

	boolean checkUsername(String username);
}
