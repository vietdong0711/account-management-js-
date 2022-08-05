package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Position", catalog = "TestingSystem")	
public class Position implements Serializable {

	@Id
	@Column(name = "PositionID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "PositionName", nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private PositionName name;

	@OneToMany(mappedBy = "position")
	private List<Account> accounts;
	public Position() {
		// TODO Auto-generated constructor stub
	}
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public PositionName getName() {
		return name;
	}
	public void setName(PositionName name) {
		this.name = name;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "PositionEntity [id=" + id + ", name=" + name + ", accounts=" + accounts + "]";
	}
	
	
}
