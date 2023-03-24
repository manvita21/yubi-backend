package com.crud.api.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.crud.api.entity.Department;
import com.crud.api.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public Department getDepartment(long id) {
		return departmentRepository.findById(id).get();
	}

	public void deleteDepartment(long id) {
		departmentRepository.deleteById(id);
	}

	public void enterDummyData() {
		Department d1 = new Department();
		d1.setCity_name("Mumbai");
		Department d2 = new Department();
		d2.setCity_name("Chennai");
		Department d3 = new Department();
		d3.setCity_name("Banglore");
		Department d4 = new Department();
		d3.setCity_name("kochin");

		List<Department> list = new LinkedList<>();
		list.add(d2);
		list.add(d3);
		list.add(d1);
		departmentRepository.saveAll(list);
	}

	public Department getDepartentList(String tableName, String colName, String colValue) {
		String query = "select * from " + tableName + " where " + colName + " = " + "\""+colValue+"\"";
		return jdbcTemplate.queryForObject(query, Department.class);
	}

}
