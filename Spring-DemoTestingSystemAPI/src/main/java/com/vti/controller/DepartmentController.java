package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.service.IService.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/department")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IDepartmentService departmentService;

	@GetMapping()
	public ResponseEntity<?> getAllDepartment() {
		List<Department> ls = departmentService.getAllDepartments();
		List<DepartmentDTO> departmentDTOs = new ArrayList<>();
		for (Department department : ls) {
			DepartmentDTO departmentDTO = mapper.map(department, DepartmentDTO.class);
			departmentDTOs.add(departmentDTO);
		}
		return new ResponseEntity<>(departmentDTOs, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") Short id) {
		Department department = departmentService.getDepartmentByID(id);
		DepartmentDTO departmentDTO = mapper.map(department, DepartmentDTO.class);
		return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentFormForCreating departmentFormForCreate) {
		departmentService.createNewDepartment(departmentFormForCreate);
		return new ResponseEntity<>("Craete new department succes", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,
			@RequestBody DepartmentFormForCreating departmentFormForCreate) {
		Department department = mapper.map(departmentFormForCreate, Department.class);
		department.setId(id);
		departmentService.updateDepartment(department);
		return new ResponseEntity<>("update department succes", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		departmentService.deleteDepartment(id);
		return new ResponseEntity<>("delete department succes", HttpStatus.OK);
	}

}
