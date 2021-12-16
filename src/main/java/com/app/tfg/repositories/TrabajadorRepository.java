package com.app.tfg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tfg.entity.TrabajadorEntity;

public interface TrabajadorRepository extends JpaRepository<TrabajadorEntity, Integer>{

	//metodo para el loguin de trabajador
	TrabajadorEntity findByNombreAndDni(String nombre, String dni);
	
}
