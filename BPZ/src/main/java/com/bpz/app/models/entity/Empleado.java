package com.bpz.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private  String apellido;
	
	@NotNull
	private Long codigo;
	
	@NotNull
	private Long celular;
	
	@ManyToMany
	@JoinTable(name="pago_id")
	private List<Pago> pagos;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	private Cargo cargo;

	
	
	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
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

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}



	
	
	
}
