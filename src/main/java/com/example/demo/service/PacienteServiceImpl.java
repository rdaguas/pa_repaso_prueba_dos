package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.modelo.Paciente;
@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
	public void agregar(Paciente paciente) {
		this.pacienteRepository.agregar(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.pacienteRepository.actualizar(paciente);
	}

	@Override
	public Paciente encontrar(String cedula) {
		// TODO Auto-generated method stub
		return this.pacienteRepository.encontrar(cedula);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.pacienteRepository.eliminar(cedula);
		
	}

}
