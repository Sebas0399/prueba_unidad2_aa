package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Doctor;

@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);
	}

	@Override
	public Doctor buscar(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Doctor> miQuery = this.entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cedula=:cedula",
				Doctor.class);
		miQuery.setParameter("cedula", cedula);

		return miQuery.getSingleResult();
	}
}
