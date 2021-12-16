package com.app.tfg.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.tfg.entity.ClienteEntity;
import com.app.tfg.entity.TrabajadorEntity;
import com.app.tfg.repositories.ClienteRepository;
import com.app.tfg.repositories.TrabajadorRepository;

@RestController
public class AuthController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TrabajadorRepository trabajadorRepository;
	
//metodo para login comprueba que existe el cliente que esta logueandose
	@PostMapping("/login/cliente")
	public String login(@RequestBody ClienteEntity cliente){
		
		System.out.println(cliente.toString());
		
		ClienteEntity result = clienteRepository.findByNombreAndDni(cliente.getNombre(), cliente.getDni());

		if(Objects.nonNull(result)) {			
			return String.valueOf(result.getId());
		}
		
		return "KO";
	}
	//metodo para login del trabajador comprobando que existe ese trabajado en la base de datos
	@PostMapping("/login/trabajador")
	public String logintra(@RequestBody TrabajadorEntity trabajador){
		
		System.out.println(trabajador.toString());
		TrabajadorEntity result = trabajadorRepository.findByNombreAndDni(trabajador.getNombre(), trabajador.getDni());

		if(Objects.nonNull(result)) {
			return String.valueOf(result.getCodigo());
		}
		
		return "KO";
	}	
	
}
