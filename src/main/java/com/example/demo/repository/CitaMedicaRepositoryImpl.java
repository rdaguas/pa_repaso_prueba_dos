package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CitaMedica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements CitaMedicaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CitaMedica citaMedica) {
		this.entityManager.persist(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		this.entityManager.merge(citaMedica);
		
	}

	@Override
	public CitaMedica seleccionar(String cedula) {
		CitaMedica cime = this.seleccionar(cedula);
		return this.entityManager.find(CitaMedica.class, cime);
	}

	@Override
	public void eliminar(String cedula) {
		this.entityManager.remove(cedula);
		
	}

	@Override
	public CitaMedica seleccionarPorNumero(String numero) {
	//typedQuery, singleResult	
	//Parte nueva por aprender
	//QUERY TIPED
	//SELECT e FROM
	TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery("SELECT cm FROM CitaMedica cm WHERE cm.numeroTurno= :datoNumero", CitaMedica.class);
	myQuery.setParameter("datoNumero", numero);
	return myQuery.getSingleResult();
	}

	@Override
	public CitaMedica actualizarPorNumero(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		return this.entityManager.merge(citaMedica);
	}

	@Override
	public List<CitaMedica> reporteFinal() {
		
		LocalDate f1 = LocalDate.of(2023, 6, 29);
		LocalDate f2 = LocalDate.of(2023, 6, 30);
		BigDecimal cos = new BigDecimal(20);
		
		
		TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery("SELECT cm FROM CitaMedica cm WHERE cm.fechaCita BETWEEN :datoFechaInicio AND :datoFechaFin AND cm.costoCita = :datoCosto", CitaMedica.class);
		myQuery.setParameter("datoFechaInicio", f1);
		myQuery.setParameter("datoFechaFin", f2);
		myQuery.setParameter("datoCosto", cos);
				
		return myQuery.getResultList();
		}

}
