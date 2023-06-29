package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Persona;
import com.example.demo.service.PersonaService;

@SpringBootApplication
public class PaRepasoPruebaDosApplication implements CommandLineRunner{
	
	@Autowired
	private PersonaService personaService;

	public static void main(String[] args) {
		SpringApplication.run(PaRepasoPruebaDosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Persona pers = new Persona();
		pers.setNombre("Luis");
		pers.setApellido("Valladares");
		pers.setValor(new BigDecimal(600));
		
		Persona pers2 = new Persona();
		pers2.setNombre("Daniel");
		pers2.setApellido("Bolaños");
		pers2.setValor(new BigDecimal(100));
		
		//this.personaService.agregar(pers);
		//this.personaService.agregar(pers2);
		pers.setId(5);
		this.personaService.actualizar(pers);
		System.out.println(this.personaService.buscar("6"));
		this.personaService.eliminar("8");
		
	}

}
