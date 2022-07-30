package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;

@Service
public class GestorCitaImpl implements IGestorCita{
	@Autowired
	private IPacienteRepository pacienteRepo;
	@Autowired
	private IDoctorRepository doctorRepo;
	@Autowired
	private ICitaMedicaRepository citaRepo;
	@Override
	public void agendamiento(String numeroTurno, LocalDateTime fechaCita, String costoCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		Paciente p=this.pacienteRepo.buscar(cedulaPaciente);
		Doctor d=this.doctorRepo.buscar(cedulaDoctor);
		CitaMedica cm=new CitaMedica();
		cm.setNumero(numeroTurno);
		cm.setFechaCita(fechaCita);
		cm.setValorCita(new BigDecimal(costoCita));
		cm.setLugarCita(lugarCita);
		cm.setDoctor(d);
		cm.setPaciente(p);
		this.citaRepo.insertar(cm);
	}
	@Override
	public void actualizar(String numero, String diagnostico, String Receta, LocalDateTime fechaControl) {
		// TODO Auto-generated method stub
		CitaMedica cm=this.citaRepo.buscarPorNumero(numero);
		cm.setDiagnostico(diagnostico);
		cm.setReceta(Receta);
		cm.setFechaControl(fechaControl);
		this.citaRepo.actualizar(cm);
	}
	@Override
	public void reporte(LocalDateTime fechaCita, BigDecimal costo) {
		// TODO Auto-generated method stub
		this.citaRepo.buscarPorFechaCosto(fechaCita, costo);
	}

}
