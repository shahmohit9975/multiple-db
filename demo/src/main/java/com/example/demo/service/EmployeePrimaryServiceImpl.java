package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.primary.Employee;
import com.example.demo.repo.primary.EmployeePrimaryRepo;

@Service
public class EmployeePrimaryServiceImpl implements EmployeePrimaryService {

	@Autowired
	private EmployeePrimaryRepo primaryRepository;

	@PersistenceContext(unitName = "primaryEntityManagerFactory")
	private EntityManager em1;

	private final Logger log = LoggerFactory.getLogger(EmployeePrimaryServiceImpl.class);

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = primaryRepository.findAll();
		log.info("DB-1 employee details:" + employees);

		int totalRecords = ((Number) em1.createNativeQuery("SELECT count(*) FROM EMPLOYEE").getSingleResult())
				.intValue();
		log.info("DB-1 total employee count:" + totalRecords);

		return employees;
	}

}
