package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CitaMedicaRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService{
	
	@Autowired
	private CitaMedicaRepository citaMedicaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public void agregar(String numeroTurno, LocalDate fechaCita, BigDecimal costoCita,  String lugar,
			String cedulaDoctor, String cedulaPaciente) {
		
		Doctor doct = this.doctorRepository.encontrar(cedulaDoctor);
		Paciente paci = this.pacienteRepository.encontrar(cedulaPaciente);
		
		CitaMedica cime = new CitaMedica();
		cime.setNumeroTurno(numeroTurno);
		cime.setFechaCita(fechaCita);
		cime.setCostoCita(costoCita);
		cime.setLugarCita(lugar);
		cime.setDoctor(doct);
		cime.setPaciente(paci);
		cime.setDiagnostico("Fiebre Cronica");
		cime.setFechaControl(LocalDate.of(2023, 06, 24));
		cime.setReceta("IBUPROFENO 500ML");
		
		this.citaMedicaRepository.insertar(cime);
	}

	@Override
	public void actulizarPorNumero(String numero, String diagnostico, String receta, LocalDate fechaControl) {
		// TODO Auto-generated method stub
		CitaMedica cime = this.citaMedicaRepository.seleccionarPorNumero(numero);
		cime.setDiagnostico(diagnostico);
		cime.setReceta(receta);
		cime.setFechaControl(fechaControl);
		this.citaMedicaRepository.actualizarPorNumero(cime);
	}

	

	@Override
	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public List<CitaMedica> seleccionarPorFechayCostoReporte() {
		
		
		return this.citaMedicaRepository.reporteFinal();
	}

}
