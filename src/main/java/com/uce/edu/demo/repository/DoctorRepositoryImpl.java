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

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Doctor d=this.buscar(id);
		this.entityManager.remove(d);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
	}

	@Override
	public Doctor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}
}
