package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.PositionDTO;
import com.vti.entity.Position;
import com.vti.entity.PositionName;
import com.vti.service.IService.IPositionService;

@RestController
@RequestMapping(value = "api/v1/position")
@CrossOrigin("*")
public class PositionController {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IPositionService positionService;

	// getAll
	@GetMapping()
	public ResponseEntity<?> getAllPosition() {
		List<Position> ls = positionService.getAllPosition();
		List<PositionDTO> positionDTOs = new ArrayList<>();
		for (Position position : ls) {
			PositionDTO positionDTO = mapper.map(position, PositionDTO.class);
			positionDTOs.add(positionDTO);
		}
		return new ResponseEntity<>(positionDTOs, HttpStatus.OK);
	}

	// getByID
	@GetMapping("/{id}")
	public ResponseEntity<?> getPositionByID(@PathVariable(name = "id") short id) {
		Position position = positionService.getPositionByID(id);
		PositionDTO positionDTO = mapper.map(position, PositionDTO.class);
		return new ResponseEntity<>(positionDTO, HttpStatus.OK);
	}

	// getByName
	@GetMapping("search")
	public ResponseEntity<?> getPositionByName(@RequestParam(name = "name") PositionName positionName) {
		Position position = positionService.getPositionByName(positionName);
		PositionDTO positionDTO = mapper.map(position, PositionDTO.class);
		return new ResponseEntity<>(positionDTO, HttpStatus.OK);
	}

//	// create Position
//	@PostMapping()
//	public ResponseEntity<?> createPosition(@RequestBody PositionFormForCreating positionFormForCreating) {
//		Position position = mapper.map(positionFormForCreating, Position.class);
//		positionService.createPosition(position);
//		return new ResponseEntity<>("create succes", HttpStatus.OK);
//	}

}
