package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IGestorCita {
	public void agendamiento(String numeroTurno,LocalDateTime fechaCita,String costoCita,String lugarCita,String cedulaDoctor,String cedulaPaciente);
	public void actualizar(String numero,String diagnostico,String Receta,LocalDateTime fechaControl);
	public void reporte(LocalDateTime fechaCita,BigDecimal costo);
}
