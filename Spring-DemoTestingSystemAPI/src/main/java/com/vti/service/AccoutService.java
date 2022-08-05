package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
import com.vti.service.IService.IAccountService;
import com.vti.speccification.AccountSpeccification;

@Service
public class AccoutService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public Page<Account> getAllAccount(Pageable pageable, String search) {
		Specification<Account> whereAccount = null;
		if (!StringUtils.isEmpty(search)) {
			AccountSpeccification fullnameSpeccification = new AccountSpeccification("fullName", "LIKE", search);
			AccountSpeccification emailSpeccification = new AccountSpeccification("email", "LIKE", search);
			AccountSpeccification departmentSpeccification = new AccountSpeccification("department", "LIKE", search);
			whereAccount = Specification.where(fullnameSpeccification).or(emailSpeccification)
					.or(departmentSpeccification);
		}

		return accountRepository.findAll(whereAccount, pageable);
	}

	@Override
	public Account getAllAccountByID(short id) {
		return accountRepository.getById(id);
	}

	@Override
	public Account getAccountByUsername(String name) {
		return accountRepository.findByUserName(name);
	}

	@Override
	public void deleteAccountByID(Short id) {
		accountRepository.deleteById(id);
	}

	@Override
	public void createAccout(Account account) {
		accountRepository.save(account);
	}

	@Override
	public List<Account> findByFullName(String name) {
		// TODO Auto-generated method stub
		return accountRepository.findByFullName(name);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Tim Account theo username
		Account account = accountRepository.findByUserName(username);
		if (account == null) {
			throw new UsernameNotFoundException(username);
		} else {
			return new User(account.getUserName(), account.getPassword(), AuthorityUtils.createAuthorityList("user"));
		}
	}

	@Override
	public boolean checkEmail(String email) {
		Account account = accountRepository.findByEmail(email);
		if (account == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkUsername(String username) {
		Account account = accountRepository.findByEmail(username);
		if (account == null) {
			return false;
		}
		return true;
	}

}
