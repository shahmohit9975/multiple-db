package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.primary.Employee;
import com.example.demo.service.EmployeePrimaryService;

@RestController
@RequestMapping("/api/primary/employee")
public class EmployeePrimaryController {

	@Autowired
	private EmployeePrimaryService primaryService;

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Employee>> getAllFeatures() {
		List<Employee> allEmployees = primaryService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
	}
}
