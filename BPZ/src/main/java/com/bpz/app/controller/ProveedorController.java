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
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String guardar(@Valid Proveedor proveedor, BindingResult result,Model model, RedirectAttributes flash,
			SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Proveedor");
			return "form";
		}
		String mensajeFlash = (proveedor.getIdProveedor() !=null)?"Proveedor editado con exito!":"Cliente creado con exito!";
		pService.save(proveedor);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
	
}
