package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.secondary.Employee;
import com.example.demo.repo.secondary.EmployeeSecondaryRepo;

@Service
public class EmployeeSecondaryServiceImpl implements EmployeeSecondaryService {

	@Autowired
	private EmployeeSecondaryRepo secondaryRepository;

	@PersistenceContext(unitName = "secondaryEntityManagerFactory")
	private EntityManager em2;

	private final Logger log = LoggerFactory.getLogger(EmployeeSecondaryServiceImpl.class);

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> employees = secondaryRepository.findAll();
		log.info("DB-2 employee details:" + employees);

		int totalRecords = ((Number) em2.createNativeQuery("SELECT count(*) FROM EMPLOYEE").getSingleResult())
				.intValue();
		log.info("DB-2 total employee count:" + totalRecords);
		return employees;
	}

}
