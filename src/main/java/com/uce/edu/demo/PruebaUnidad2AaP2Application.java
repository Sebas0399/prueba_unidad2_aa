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
public class PruebaUnidad2AaP2Application implements CommandLineRunner {
	@Autowired
	private IDoctorService doctorService;
	@Autowired
	private IPacienteService pacienteService;
	@Autowired
	private IGestorCita gestorCita;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2AaP2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Doctor d = new Doctor();
		d.setApellido("Arguello");
		d.setCedula("1725776650");
		d.setFechaNacimiento(LocalDateTime.now());
		d.setNombre("Antony");
		d.setNumeroConsultorio("1");
		d.setSalario("150");
		d.setTitulo("Medico Cirujano");
		this.doctorService.insertar(d);

		Doctor d2 = new Doctor();
		d2.setApellido("Morales");
		d2.setCedula("1725776656");
		d2.setFechaNacimiento(LocalDateTime.now());
		d2.setNombre("Sebastian");
		d2.setNumeroConsultorio("2");
		d2.setSalario("150");
		d2.setTitulo("Medico Pediatra");
		this.doctorService.insertar(d2);

		Paciente p2 = new Paciente();
		p2.setApellido("Muñoz");
		p2.setCedula("0201114022");
		p2.setCodigoIess("11000");
		p2.setEstatura(1.70);
		p2.setFechaNacimiento(LocalDateTime.now());
		p2.setGenero("M");
		p2.setNombre("Alejandro");
		p2.setPeso(150.0);
		this.pacienteService.insertar(p2);

		Paciente p = new Paciente();
		p.setApellido("Moncayo");
		p.setCedula("1201114022");
		p.setCodigoIess("22000");
		p.setEstatura(1.60);
		p.setFechaNacimiento(LocalDateTime.now());
		p.setGenero("F");
		p.setNombre("Alejandra");
		p.setPeso(140.0);
		this.pacienteService.insertar(p);

		this.gestorCita.agendamiento("1", LocalDateTime.now(), "20", "Consultorio 2", "1725776650", "0201114022");
		this.gestorCita.actualizar("1", "Gastritis", "Paractetamol cada 8 horas", LocalDateTime.now());
		this.gestorCita.reporte(LocalDateTime.now().minusHours(50000), new BigDecimal(0));
	}

}
