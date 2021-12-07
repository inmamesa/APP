package com.app.tfg.dao;

import org.springframework.stereotype.Service;

import com.app.tfg.entity.ClienteEntity;

@Service
public interface ClienteDao {

	boolean verificarCredenciales(ClienteEntity cliente);

	
	

}
