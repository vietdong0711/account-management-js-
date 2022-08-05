package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Position;
import com.vti.entity.PositionName;
import com.vti.repository.IPositionRepository;
import com.vti.service.IService.IPositionService;

@Service
public class PositionService implements IPositionService {
	@Autowired
	private IPositionRepository positionRepository;

	@Override
	public Position getPositionByID(short id) {
		return positionRepository.findById(id).get();
	}

	@Override
	public List<Position> getAllPosition() {
		return positionRepository.findAll();
	}

	@Override
	public Position getPositionByName(PositionName positionName) {
		return positionRepository.findByName(positionName);
	}

	@Override
	public void createPosition(Position position) {
		positionRepository.save(position);
	}

}
