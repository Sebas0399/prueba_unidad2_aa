package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Doctor;

public interface IDoctorRepository {
	public void insertar(Doctor doctor);
	public Doctor buscar(String cedula);
	public Doctor buscar(Integer id);
	public void eliminar(Integer id);
	public void actualizar(Doctor doctor);
}
