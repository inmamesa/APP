package com.app.tfg.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tfg.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{
	
	//metodo para el loguin del cliente
	ClienteEntity findByNombreAndDni(String nombre, String dni);

	//metodo para coger el codigo del trabajador
	Collection<ClienteEntity>findByTrabajador_Codigo(Integer codigo);

}
