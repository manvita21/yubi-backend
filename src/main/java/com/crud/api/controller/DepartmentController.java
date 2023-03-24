package com.crud.api.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.entity.Department;
import com.crud.api.entity.SearchCriteria;
import com.crud.api.service.DepartmentService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/departments")
	private List<Department> getDepartments(){	
		return departmentService.getDepartments();
	}
	
	@GetMapping("/department/{id}")
	private Department getDepartment(@PathVariable long id){
		
		return departmentService.getDepartment(id);
	}
	
	@PostMapping("/department")
	private Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@PutMapping("/department")
	private Department updateDepartment(@RequestBody Department department) {
		return departmentService.updateDepartment(department);
	}
	
	@DeleteMapping("/department/{id}")
	public void deleteDepartment(@PathVariable long id) {
		departmentService.deleteDepartment(id);
	}
	
	@GetMapping("/createDummy")
	public void enterDummyData() {
		departmentService.enterDummyData();
	}
	
	@PostMapping("/getdepartbycriteria")
	private Department saveDepartment(@RequestBody SearchCriteria search) {
		return departmentService.getDepartentList(search.getTableName(),search.getColName(),search.getColValue());
	}
	
}

