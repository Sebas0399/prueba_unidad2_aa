package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Paciente;

public interface IPacienteRepository {
	public void insertar(Paciente paciente);
	public Paciente buscar(String cedula);

}
