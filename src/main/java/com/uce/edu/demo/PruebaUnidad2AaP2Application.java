package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IGestorCita;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2AaP2Application implements CommandLineRunner{
	@Autowired
	private IDoctorService doctorService;
	@Autowired
	private IPacienteService pacienteService;
	@Autowired
	private IGestorCita gestorCita;
	
	@Autowired
	private ICitaMedicaRepository citaRepo;
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2AaP2Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Doctor d=new Doctor();
		d.setApellido("Arguello");
		d.setCedula("1725776650");
		d.setFechaNacimiento(LocalDateTime.now());
		d.setNombre("Antony");
		d.setNumeroConsultorio("1");
		d.setSalario("150");
		d.setTitulo("Medico Cirujano");
		this.doctorService.insertar(d);
		
		Paciente p=new Paciente();
		p.setApellido("Muñoz");
		p.setCedula("0201114022");
		p.setCodigoIess("11000");
		p.setEstatura("1.70");
		p.setFechaNacimiento(LocalDateTime.now());
		p.setGenero("M");
		p.setNombre("Alejandro");
		p.setPeso("150");
		this.pacienteService.insertar(p);
		
		this.gestorCita.agendamiento("1", LocalDateTime.now(), "20", "Consultorio 2", "1725776650", "0201114022");
		this.gestorCita.actualizar("1", "Gastritis", "Paractetamol cada 8 horas", LocalDateTime.now());
		//this.gestorCita.reporte(LocalDateTime.now().minusHours(10), new BigDecimal(0));
	}

}
