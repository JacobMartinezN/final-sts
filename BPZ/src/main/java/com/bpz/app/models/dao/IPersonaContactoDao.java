package com.bpz.app.models.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bpz.app.models.entity.PersonaContacto;


@Repository
public interface IPersonaContactoDao extends JpaRepository<PersonaContacto,Long> {
	
	//@Query("select p from persona_contacto p where p.nombre = ?1")
	//public PersonaContacto ObtenerIDPorNombre(String term);
	
}

