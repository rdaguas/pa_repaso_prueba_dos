package com.example.demo.repository;

import com.example.demo.repository.modelo.Persona;

public interface PersonaRepository {
	
	public void insertar(Persona persona);
	public void actualizar(Persona persona);
	public void borrar(String apellido);
	public Persona seleccionar(String apellido);
	
	

}
