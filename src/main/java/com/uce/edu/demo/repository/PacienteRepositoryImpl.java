package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public Paciente buscar(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> miQuery = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula=:cedula",
				Paciente.class);
		miQuery.setParameter("cedula", cedula);

		return miQuery.getSingleResult();
	}
}
