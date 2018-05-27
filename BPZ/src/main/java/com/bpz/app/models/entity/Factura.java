package com.bpz.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Factura")
public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private int codigoServicio;

	@NotNull
	private String numFactura;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fechaEmision;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fechaVencimiento;
	
	private String descripcion;
	
	@NotNull
	private String tipoMoneda;
	
	@NotNull
	private double subtotal;
	
	@NotNull
	private double igv;
	
	@NotNull
	private double total;
	
	private double porcetajeDetraccion;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="factura_id", insertable=false, updatable=false)
	private Proveedor proveedor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(int codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getPorcetajeDetraccion() {
		return porcetajeDetraccion;
	}

	public void setPorcetajeDetraccion(double porcetajeDetraccion) {
		this.porcetajeDetraccion = porcetajeDetraccion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
	

}
