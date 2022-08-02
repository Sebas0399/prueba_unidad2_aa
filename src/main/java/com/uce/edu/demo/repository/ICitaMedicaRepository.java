package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.CitaSencilla;

public interface ICitaMedicaRepository {
	public void insertar(CitaMedica citaMedica);
	public void actualizar(CitaMedica citaMedica);
	public CitaMedica buscar(Integer id);
	public void eliminar(Integer id);
	public CitaMedica buscarPorNumero(String numero);
	public List<CitaSencilla> buscarPorFechaCosto(LocalDateTime fecha,BigDecimal costo);
}
