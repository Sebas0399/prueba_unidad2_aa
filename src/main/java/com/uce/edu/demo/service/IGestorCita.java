package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.CitaSencilla;

public interface IGestorCita {
	public void agendamiento(String numeroTurno,LocalDateTime fechaCita,String costoCita,String lugarCita,String cedulaDoctor,String cedulaPaciente);
	public void actualizar(String numero,String diagnostico,String Receta,LocalDateTime fechaControl);
	public List<CitaSencilla> reporte(LocalDateTime fechaCita,BigDecimal costo);
}
