package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.repository.IDepartmentRepository;
import com.vti.service.IService.IDepartmentService;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepository;

	@Override
	public List<Department> getAllDepartments() {

		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentByID(short id) {
		return departmentRepository.findById(id).get();
	}

	@Override
	public void createNewDepartment(DepartmentFormForCreating departmentFormForCreate) {
		Department department = new Department();
		department.setName((departmentFormForCreate.getName()));
		departmentRepository.save(department);
	}

	@Override
	public void updateDepartment(Department department) {
		departmentRepository.save(department);
	}

	@Override
	public void deleteDepartment(short id) {
		departmentRepository.deleteById(id);

	}

}
