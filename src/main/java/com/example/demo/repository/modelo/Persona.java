package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {
	
	@GeneratedValue(generator = "seq_persona",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_persona",sequenceName = "seq_persona", allocationSize = 1)
	@Id
	@Column(name="pers_id")
	private Integer id;
	
	@Column(name="pers_nombre")
	private String nombre;
	
	@Column(name="pers_apellido")
	private String apellido;
	
	@Column(name="pers_valor")
	private BigDecimal valor;

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", valor=" + valor + "]";
	}
	
	
	

}
