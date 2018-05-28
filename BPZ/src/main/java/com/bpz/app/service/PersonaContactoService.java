package com.bpz.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bpz.app.models.dao.IPersonaContactoDao;
import com.bpz.app.models.entity.PersonaContacto;

@Service
public class PersonaContactoService implements IPersonaContactoService{

	
	@Autowired
	private IPersonaContactoDao personacontactoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PersonaContacto> findAll() {
		
		return personacontactoDao.findAll();
	}

	@Override
	@Transactional
	public void save(PersonaContacto personaContacto) {
		personacontactoDao.save(personaContacto);
	}

//	@Override
//	@Transactional(readOnly = true)
//	public PersonaContacto ObtenerIDPorNombre(String nombre) {
//		// TODO Auto-generated method stub
//		return personacontactoDao.ObtenerIDPorNombre(nombre);
//		
//	}

	
}
