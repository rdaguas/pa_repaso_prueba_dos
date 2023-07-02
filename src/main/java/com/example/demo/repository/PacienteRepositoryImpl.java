package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class PacienteRepositoryImpl implements PacienteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void agregar(Paciente paciente) {
		this.entityManager.persist(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);
		
	}

	@Override 
	public Paciente encontrar(String cedula) {
		TypedQuery<Paciente> myQuery = this.entityManager.createQuery("SELECT cm FROM Paciente cm WHERE cm.cedula= :datoCedula", Paciente.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
		}
	@Override
	public void eliminar(String cedula) {
		this.entityManager.remove(cedula);
	}

}
