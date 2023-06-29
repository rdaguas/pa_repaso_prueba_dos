package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class PersonaRepositoryImpl implements PersonaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Persona persona) {
		this.entityManager.persist(persona);
		
	}

	@Override
	public void actualizar(Persona persona) {
		this.entityManager.merge(persona);
		
	}

	@Override
	public void borrar(String apellido) {
		Persona per = this.seleccionar(apellido);
		this.entityManager.remove(per);
		
	}

	@Override
	public Persona seleccionar(String apellido) {
		
		return this.entityManager.find(Persona.class, apellido);
	}

	

}
