package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.CitaMedica;

public interface CitaMedicaService {
	
	//CRUD
	public void agregar(String numeroTurno, LocalDate fechaCita, BigDecimal costoCita,
			String lugar, String cedullaDoctor, String cedulaPaciente);	
	
	public void actulizarPorNumero(String numero, String diagnostico, String receta, LocalDate fechaControl);

	public CitaMedica buscarPorNumero(String numero);
	public List<CitaMedica> seleccionarPorFechayCostoReporte();
}
