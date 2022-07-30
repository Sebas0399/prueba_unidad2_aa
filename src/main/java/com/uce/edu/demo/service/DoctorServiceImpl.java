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

}
