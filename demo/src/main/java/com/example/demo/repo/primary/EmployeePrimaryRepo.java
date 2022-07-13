package com.example.demo.repo.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.primary.Employee;

@Repository
public interface EmployeePrimaryRepo extends JpaRepository<Employee, Integer>{

}
