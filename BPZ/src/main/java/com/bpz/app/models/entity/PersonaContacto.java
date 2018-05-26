package com.bpz.app.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Persona_Contacto")
public class PersonaContacto {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private  String apellido;
	
	@NotNull
	private Long dni;
	
	//Fran estuvo aqui
	
	@NotNull
	private Long celular;
	
	@NotNull
	@Email
	private String correo;
	
}
