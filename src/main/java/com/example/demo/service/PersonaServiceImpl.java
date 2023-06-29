package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PersonaRepository;
import com.example.demo.repository.modelo.Persona;
@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public void agregar(Persona persona) {
		this.personaRepository.insertar(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		this.personaRepository.actualizar(persona);
	}

	@Override
	public void eliminar(String apellido) {
		this.personaRepository.borrar(apellido);		
	}

	@Override
	public Persona buscar(String apellido) {
		// TODO Auto-generated method stub
		return this.personaRepository.seleccionar(apellido);
	}

}
