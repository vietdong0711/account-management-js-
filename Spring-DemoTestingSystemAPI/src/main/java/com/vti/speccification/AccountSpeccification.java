package com.vti.speccification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Account;

public class AccountSpeccification implements Specification<Account> {

	private String field;
	private String operator;
	private Object value;

	@Override
	public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (operator.equals("LIKE")) {
			if (field.equals("department")) {

				return criteriaBuilder.like(root.get(field).get("name"), "%" + value.toString() + "%");
			} else {

				return criteriaBuilder.like(root.get(field), "%" + value.toString() + "%");
			}

		}
		return null;
	}

	public AccountSpeccification(String field, String operator, Object value) {
		super();
		this.field = field;
		this.operator = operator;
		this.value = value;
	}

}
