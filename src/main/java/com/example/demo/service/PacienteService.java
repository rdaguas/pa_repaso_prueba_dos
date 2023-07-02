package com.example.demo.service;

import com.example.demo.repository.modelo.Paciente;

public interface PacienteService {
	
	//CRUD
	public void agregar(Paciente paciente);
		public void actualizar(Paciente paciente);
		public Paciente encontrar(String cedula);
		public void eliminar(String cedula);

}
