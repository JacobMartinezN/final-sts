package com.bpz.app.service;

import java.util.List;

import com.bpz.app.models.entity.Proveedor;



public interface IProveedorService {

	public List<Proveedor> findAll();
	
	public void save(Proveedor proovedor);
}
