package com.sotofit.Ifraud.DaoImplementation;

import com.sotofit.Ifraud.Dao.StudentDAO;
import com.sotofit.Ifraud.entities.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;

	public void StudentDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
    @Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}
}
