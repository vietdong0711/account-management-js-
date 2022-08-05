package com.vti.DTO;

import com.vti.entity.PositionName;

public class PositionDTO {

	private short id;

	private PositionName name;

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

}
