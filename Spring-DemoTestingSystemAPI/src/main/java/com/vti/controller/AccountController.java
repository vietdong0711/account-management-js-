package com.vti.controller;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForRegister;
import com.vti.form.AccountFormForUpdating;
import com.vti.service.IService.IAccountService;
import com.vti.service.IService.IDepartmentService;
import com.vti.service.IService.IPositionService;

@RestController
@RequestMapping(value = "api/v1/account")
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private IAccountService accountService;
	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private IPositionService positionService;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// get all
	@GetMapping
	public ResponseEntity<?> getAllAccount(Pageable pageable, @RequestParam(required = false) String search) {
		// Lấy dữ liệu theo phân trang
		Page<Account> ls_Page = accountService.getAllAccount(pageable, search);
		Page<AccountDTO> accountDTOs = ls_Page.map(new Function<Account, AccountDTO>() {

			@Override
			public AccountDTO apply(Account account) {
				AccountDTO accountDTO = mapper.map(account, AccountDTO.class);
				accountDTO.setDepartmentName(account.getDepartment().getName());
				accountDTO.setPositionName(account.getPosition().getName().toString());
				return accountDTO;
			}
		});
//		for (Account account : ls) {
//			AccountDTO accountDTO = map.map(account, AccountDTO.class);
//			accountDTO.setDepartmentName(account.getDepartment().getName());
//			accountDTO.setPositionName(account.getPosition().getName().toString());
//			accountDTOs.add(accountDTO);
//		}
		return new ResponseEntity<>(accountDTOs, HttpStatus.OK);
	}

	// getByID
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllAccountByID(@PathVariable(name = "id") short id) {
		Account account = accountService.getAllAccountByID(id);
		AccountDTO accountDTO = mapper.map(account, AccountDTO.class);
		accountDTO.setDepartmentName(account.getDepartment().getName());
		accountDTO.setPositionName(account.getPosition().getName().toString());
		return new ResponseEntity<>(accountDTO, HttpStatus.OK);
	}

	// getByUserName
	@GetMapping("search")
	public ResponseEntity<?> getAllAccountByUsername(@RequestParam(name = "username") String username) {
		Account account = accountService.getAccountByUsername(username);
		if (account != null) {
			AccountDTO accountDTO = mapper.map(account, AccountDTO.class);
			accountDTO.setDepartmentName(account.getDepartment().getName());
			accountDTO.setPositionName(account.getPosition().getName().toString());
			return new ResponseEntity<>(accountDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>("null", HttpStatus.OK);
	}

	// deleteByID
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteAccountByID(@PathVariable(name = "id") Short id) {
		accountService.deleteAccountByID(id);
		return new ResponseEntity<>("delete succes", HttpStatus.OK);
	}

	// create Account
	@PostMapping()
	public ResponseEntity<?> getAllAccountByUsername(@RequestBody AccountFormForCreating accountFormForCreating) {
		Account account = mapper.map(accountFormForCreating, Account.class);
		account.setDepartment(departmentService.getDepartmentByID(accountFormForCreating.getDepartmentId()));
		account.setPosition(positionService.getPositionByID(accountFormForCreating.getPositionId()));
		account.setPassword(passwordEncoder.encode("123456"));
		accountService.createAccout(account);

		return new ResponseEntity<>("create succes", HttpStatus.OK);
	}

	// upadte Account
	@PutMapping("update/{id}")
	public ResponseEntity<?> getAllAccountByUsername(@PathVariable(name = "id") Short id,
			@RequestBody AccountFormForUpdating accountFormForCreating) {
		Account account = accountService.getAllAccountByID(id);
		account.setFullName(accountFormForCreating.getFullName());
		account.setDepartment(departmentService.getDepartmentByID(accountFormForCreating.getDepartmentId()));
		account.setPosition(positionService.getPositionByID(accountFormForCreating.getPositionId()));
		accountService.createAccout(account);
		return new ResponseEntity<>("update succes", HttpStatus.OK);
	}

	@PostMapping(value = "/register")
	public ResponseEntity<?> RegisterAccount(@RequestBody AccountFormForRegister form) {
		Account account = mapper.map(form, Account.class);
		account.setDepartment(departmentService.getDepartmentByID(form.getDepartmentId()));
		account.setPosition(positionService.getPositionByID(form.getPositionId()));
		account.setPassword(passwordEncoder.encode(form.getPassword()));
		accountService.createAccout(account);

		return new ResponseEntity<>("register succes", HttpStatus.OK);
	}

	@GetMapping("checkEmail")
	public ResponseEntity<?> checkEmail(@RequestParam(name = "email") String email) {
		String aString = "";
		if (accountService.checkEmail(email) == true) {
			aString = "true";
		} else {
			aString = "false";
		}

		return new ResponseEntity<>(aString, HttpStatus.OK);
	}

	@GetMapping("checkUsername")
	public ResponseEntity<?> checkUsername(@RequestParam(name = "username") String username) {
		String aString = "";
		if (accountService.checkUsername(username) == true) {
			aString = "true";
		} else {
			aString = "false";
		}
		return new ResponseEntity<>(aString, HttpStatus.OK);
	}

}
