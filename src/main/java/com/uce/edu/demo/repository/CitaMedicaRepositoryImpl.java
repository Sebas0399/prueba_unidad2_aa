package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.CitaSencilla;
import com.uce.edu.demo.repository.modelo.Doctor;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
	}

	@Override
	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> miQuery = this.entityManager
				.createQuery("SELECT c FROM CitaMedica c WHERE c.numero=:numero", CitaMedica.class);
		miQuery.setParameter("numero", numero);

		return miQuery.getSingleResult();

	}

	@Override
	public List<CitaSencilla> buscarPorFechaCosto(LocalDateTime fecha, BigDecimal costo) {
		// TODO Auto-generated method stub

		TypedQuery<CitaSencilla> miQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.CitaSencilla(c.numero,c.fechaCita,c.valorCita,c.fechaControl)FROM CitaMedica c WHERE c.fechaCita>:fecha AND c.valorCita>:costo",
				CitaSencilla.class);
		miQuery.setParameter("fecha", fecha);
		miQuery.setParameter("costo", costo);
		return miQuery.getResultList();
	}

	@Override
	public CitaMedica buscar(Integer id) {
		// TODO Auto-generated method stub
	
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		CitaMedica cm=this.buscar(id);
		this.entityManager.remove(cm);
	}

}
