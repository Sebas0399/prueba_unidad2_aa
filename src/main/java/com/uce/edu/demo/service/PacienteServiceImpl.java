package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.Paciente;
@Service
public class PacienteServiceImpl implements IPacienteService{
	@Autowired
	private IPacienteRepository pacienteRepo;
	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepo.insertar(paciente);
	}
	@Override
	public Paciente buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscarCedula(cedula);
	}
	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscar(id);
	}
	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepo.actualizar(paciente);
		}
	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.pacienteRepo.eliminar(id);
	}

}
