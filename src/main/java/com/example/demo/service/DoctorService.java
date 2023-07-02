package com.example.demo.service;

import com.example.demo.repository.modelo.Doctor;

public interface DoctorService {

	//CRUD
	public void agregar(Doctor doctor);
		public void actualizar(Doctor doctor);
		public Doctor encontrar(String cedula);
		public void eliminar(String cedula);
}
