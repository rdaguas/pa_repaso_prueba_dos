package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.modelo.Doctor;
@Service
public class DoctorServiveImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public void agregar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepository.agregar(doctor);
		
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepository.actualizar(doctor);
		
	}

	@Override
	public Doctor encontrar(String cedula) {
		// TODO Auto-generated method stub
		return this.doctorRepository.encontrar(cedula);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.doctorRepository.eliminar(cedula);
	}

}
