package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Position;
import com.vti.entity.PositionName;

public interface IPositionRepository extends JpaRepository<Position, Short> {
	Position findByName(PositionName name);
}
