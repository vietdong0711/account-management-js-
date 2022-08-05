package com.vti.service.IService;

import java.util.List;

import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;

public interface IDepartmentService {

	List<Department> getAllDepartments();

	Department getDepartmentByID(short id);

	void createNewDepartment(DepartmentFormForCreating departmentFormForCreate);

	void updateDepartment(Department department);

	void deleteDepartment(short id);
}
