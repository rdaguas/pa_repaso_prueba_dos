package com.example.demo.service;

import com.example.demo.repository.modelo.Persona;

public interface PersonaService {
	
	public void agregar(Persona persona);
	public void actualizar(Persona persona);
	public void eliminar(String apellido);
	public Persona buscar(String apellido);

}
