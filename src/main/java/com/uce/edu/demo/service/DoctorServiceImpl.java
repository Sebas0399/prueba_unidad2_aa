package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.modelo.Doctor;
@Service
public class DoctorServiceImpl implements IDoctorService{
	@Autowired
	private IDoctorRepository doctorRepo;
	@Override
	public void insertar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepo.insertar(doctor);
	}
	@Override
	public Doctor buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscar(cedula);
	}
	@Override
	public Doctor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscar(id);
	}
	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.doctorRepo.eliminar(id);
	}
	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepo.actualizar(doctor);
	}

}
