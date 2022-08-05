package com.vti.controller;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.AccountDTO;
import com.vti.entity.Account;
import com.vti.service.IService.IAccountService;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private IAccountService accountService;

	@GetMapping()
	public ResponseEntity<?> login(Principal principal) {

		String username = principal.getName();
		// Tim account tương ứng dựa vào username
		Account accountLogin = accountService.getAccountByUsername(username);
		AccountDTO accountDTO = mapper.map(accountLogin, AccountDTO.class);
		accountDTO.setDepartmentName(accountLogin.getDepartment().getName());
		accountDTO.setPositionName(accountLogin.getPosition().getName().toString());
		return new ResponseEntity<>(accountDTO, HttpStatus.OK);
	}

}
