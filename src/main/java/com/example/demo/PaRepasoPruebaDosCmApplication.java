package com.example.demo;

import java.awt.color.CMMException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.CitaMedicaService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PacienteService;

@SpringBootApplication
public class PaRepasoPruebaDosCmApplication implements CommandLineRunner{
	
	@Autowired
	private CitaMedicaService citaMedicaService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PacienteService pacienteService;

	public static void main(String[] args) {
		SpringApplication.run(PaRepasoPruebaDosCmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Agregar 2 doctores
		Doctor doct = new Doctor();
		doct.setCedula("1724");
		doct.setNombre("Roberto");
		doct.setApellido("Aguas");
		doct.setFechaNacimineto(LocalDate.of(1980, 06, 30));
		doct.setNumeroConsultorio("201a");
		doct.setTitulo("Cirujano Plastico");
		doct.setSalario(new BigDecimal(1000));
		
		Doctor doct2 = new Doctor();
		doct2.setCedula("1234");
		doct2.setNombre("Daniel");
		doct2.setApellido("Valencia");
		doct2.setFechaNacimineto(LocalDate.of(2001, 05, 23));
		doct2.setNumeroConsultorio("12ba");
		doct2.setTitulo("Cirujano Neurologico");
		doct2.setSalario(new BigDecimal(2000));		
		//this.doctorService.agregar(doct2);
		
		//Agregar 2 Pacientes
		Paciente paci = new Paciente();
		paci.setCedula("5555");
		paci.setNombre("Felipe");
		paci.setApellido("Ramos");
		paci.setFechaNacimiento(LocalDate.of(2001, 02, 12));
		paci.setCodigoIess("13337");
		paci.setEstatura("1.75");
		paci.setPeso("79 kg");
		paci.setGenero("Masculino");
		
		Paciente paci2 = new Paciente();
		paci2.setCedula("1111");
		paci2.setNombre("Anthony");
		paci2.setApellido("Tipan");
		paci2.setFechaNacimiento(LocalDate.of(2004, 06, 1));
		paci2.setCodigoIess("15566");
		paci2.setEstatura("1.80");
		paci2.setPeso("66 kg");
		paci2.setGenero("Masculino");
		
		this.pacienteService.agregar(paci2);
		
	
		
		this.citaMedicaService.agregar("123456", LocalDate.now(), new BigDecimal(1234), 
				"Quito", "1724", "5555");
//		this.citaMedicaService.actulizarPorNumero("123456", "hECH gATO", "SE DE DE BAJA", LocalDate.now());
		
		//CitaMedica citaMedicaAux = this.citaMedicaService.buscarPorNumero("123456");
		
		//List<CitaMedica> citaMedicas = this.citaMedicaService.seleccionarPorFechayCostoReporte();
		
		//System.out.println("++++++++");
		//citaMedicas.stream().forEach(System.out::println);
		//System.out.println(citaMedicas.toString());
		
	}

}
