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

}
