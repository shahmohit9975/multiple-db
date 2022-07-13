package com.example.demo.repo.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.secondary.Employee;

@Repository
public interface EmployeeSecondaryRepo extends JpaRepository<Employee, Integer>{

}
