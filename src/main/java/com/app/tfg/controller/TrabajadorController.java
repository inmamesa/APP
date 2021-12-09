package com.app.tfg.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.tfg.controller.data_table.DataTableObjectCliente;
import com.app.tfg.dominio.Cliente;
import com.app.tfg.entity.ClienteEntity;
import com.app.tfg.entity.TrabajadorEntity;
import com.app.tfg.repositories.ClienteRepository;
import com.app.tfg.repositories.TrabajadorRepository;

@RestController
public class TrabajadorController {
	
	@Autowired
	private TrabajadorRepository trabajadorRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	@GetMapping(value="/trabajador", produces = MediaType.APPLICATION_JSON_VALUE)
	public DataTableObjectCliente findTrabajador(Integer codigo){
		
		System.out.println("TrabajadorController.codigo: "+codigo);
		TrabajadorEntity result = trabajadorRepository.findById(codigo).stream().findFirst().orElse(null);		
		
		DataTableObjectCliente dto= new DataTableObjectCliente();
		
		if(Objects.nonNull(result)) {
			dto.setData(this.mapperCliente(result.getClienteCollection()));
		}else {
			dto.setData(Collections.emptyList());
		}
		
		return dto;
	}
	
	
	@DeleteMapping("/trabajador/eliminar")
    public void eliminar(Integer idCliente) {
		
		clienteRepository.deleteById(idCliente);
		System.out.println(idCliente);
        
    }
	
	@PostMapping("/trabajador/registrar")
	public void registrar(Integer codigo, ClienteEntity cliente)
	{
		System.out.println(cliente.toString());
		System.out.println(codigo);
		TrabajadorEntity result = trabajadorRepository.findById(codigo).stream().findFirst().orElse(null);
		//cliente.setTrabajador(result);
		
		if(Objects.nonNull(result)) {
			result.getClienteCollection().add(cliente);
			trabajadorRepository.save(result);
			
		}
		System.out.println(cliente.toString());
		
		
	}
	
	private Collection<Cliente> mapperCliente(Collection<ClienteEntity> source){
		
		Collection<Cliente> result = new ArrayList<>();
		source.stream().forEach(cliente -> result.add(new Cliente(cliente.getId(), cliente.getDni(), cliente.getNombre(), cliente.getApellidos())));
		return result;
	}

}
