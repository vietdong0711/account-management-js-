package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Department;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Short> {

//	List<Department> findAllOrderById();
}
