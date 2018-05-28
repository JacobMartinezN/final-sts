package com.bpz.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bpz.app.models.entity.Proveedor;
import com.bpz.app.service.IProveedorService;


@Controller
@SessionAttributes("proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorService pService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model){
		model.addAttribute("titulo", "Listado de proveedores");
		model.addAttribute("proveedores", pService.findAll());
		return "listar";	
	}
	
	
	
	
}
