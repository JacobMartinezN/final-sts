package com.bpz.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bpz.app.models.entity.Contenedor;
import com.bpz.app.models.entity.PersonaContacto;
import com.bpz.app.models.entity.Proveedor;
import com.bpz.app.service.IPersonaContactoService;
import com.bpz.app.service.IProveedorService;


@Controller
@SessionAttributes("proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorService pService;
	@Autowired
	private IPersonaContactoService pCService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model){
		model.addAttribute("titulo", "Listado de proveedores");
		model.addAttribute("proveedores", pService.findAll());
		return "listar";	
	}
	
	@RequestMapping(value = "/form")
	public String crear(Model model) {

		Contenedor contenedor = new Contenedor();
		model.addAttribute("contenedor", contenedor);
		model.addAttribute("titulo", "Crear");
		return "form";
	}
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String guardar(@Valid Contenedor contenedor, BindingResult result,Model model, RedirectAttributes flash,
			SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Proveedor");
			return "form";
		}
		
		pCService.save(contenedor.getPersonacontacto());
		Proveedor proveedorCompleto = new Proveedor();
		proveedorCompleto = contenedor.getProveedor();
		PersonaContacto personacontacto = new PersonaContacto();
		personacontacto = pCService.findByDni(contenedor.getPersonacontacto().getDni());
		proveedorCompleto.setPersonaContacto(personacontacto);
				
		pService.save(proveedorCompleto);
		
		status.setComplete();
		
		return "redirect:listar";
	}
	
	
}
