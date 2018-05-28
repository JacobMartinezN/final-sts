package com.bpz.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "persona_contacto")
public class PersonaContacto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonaContacto;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private  String apellido;
	
	@NotNull
	private Long dni;
	
	@NotNull
	private Long celular;
	
	@NotNull
	@Email
	private String correo;
	
	@OneToOne(mappedBy="personaContacto",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	Proveedor proveedor;
	

	public Long getId() {
		return idPersonaContacto;
	}

	public void setId(Long id) {
		this.idPersonaContacto = id;
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

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
	
	
	
	
}
