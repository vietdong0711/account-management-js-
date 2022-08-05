package com.vti.service.IService;

import java.util.List;

import com.vti.entity.Position;
import com.vti.entity.PositionName;

public interface IPositionService {

	Position getPositionByID(short id);

	List<Position> getAllPosition();

	Position getPositionByName(PositionName positionName);

	void createPosition(Position position);

}
