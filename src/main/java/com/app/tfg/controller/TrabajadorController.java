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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	

	//metodo para devolver los clientes que tiene el trabajador logueado. mappeando el cliente entity con el de dominio para poder mostrarlo en la tabla
	@GetMapping(value="/trabajador", produces = MediaType.APPLICATION_JSON_VALUE)
	public DataTableObjectCliente findTrabajador(Integer codigo){
		
		System.out.println("TrabajadorController.codigo: "+codigo);
		//para no coger nulos cuando este comprobando el codigo del trabajador para mostrar los clientes que tiene dicho trabajador
		TrabajadorEntity result = trabajadorRepository.findById(codigo).stream().findFirst().orElse(null);		
		
		DataTableObjectCliente dto= new DataTableObjectCliente();
		
		if(Objects.nonNull(result)) {
			dto.setData(this.mapperCliente(result.getClienteCollection()));
		}else {
			dto.setData(Collections.emptyList());
		}
		
		return dto;
	}
	
	//metodo para eleiminar el cliente seleccionado en la tabla que lo hacemos en el js
	@DeleteMapping("/trabajador/eliminar")
    public void eliminar(Integer idCliente) {
		
		clienteRepository.deleteById(idCliente);
		System.out.println(idCliente);
        
    }
	
	//metodo para registrar el cliente
	@PostMapping("/trabajador/{codigo}/registrar")
	public void registrar(@PathVariable Integer codigo, @RequestBody Cliente cliente)
	{
		System.out.println(cliente.toString());
		System.out.println(codigo);
		TrabajadorEntity trabajadorEntity = trabajadorRepository.findById(codigo).stream().findFirst().orElse(null);
		//cliente.setTrabajador(result);
		
		if(Objects.nonNull(trabajadorEntity)) {
			trabajadorEntity.getClienteCollection().add(mapperClienteEntity(cliente,trabajadorEntity));
			trabajadorRepository.save(trabajadorEntity);
			
		}
		
	}
	//metodo para modificar un cliente seleccionado y despues guardar los cambios
	@PutMapping("/trabajador/{codigo}/cliente/{idCliente}/modificar")
	public void modificar(@PathVariable Integer codigo,@PathVariable Integer idCliente, @RequestBody Cliente cliente)
	{
		System.out.println(cliente.toString());
		System.out.println(codigo);
		TrabajadorEntity trabajadorEntity = trabajadorRepository.findById(codigo).orElse(null);
		
		for (ClienteEntity clienteEntity: trabajadorEntity.getClienteCollection()) {
			if(clienteEntity.getId() == idCliente)
			{
				clienteEntity.setNombre(cliente.getNombre());
				clienteEntity.setApellidos(cliente.getApellidos());
				clienteEntity.setDni(cliente.getDni());
				clienteEntity.setTrabajador(trabajadorEntity);
			   
			}
		}
		trabajadorRepository.save(trabajadorEntity);
	}
	
	//metodo para devolver el cliente seleccionado para el modificar
	@GetMapping(value="/trabajador/cliente/{idCliente}")
	public Cliente findCliente(@PathVariable Integer idCliente){
		
		ClienteEntity clienteEntity = clienteRepository.findById(idCliente).stream().findFirst().orElse(null);		
		
		if(Objects.nonNull(clienteEntity)) {
			return new Cliente(clienteEntity.getId(),clienteEntity.getDni(),clienteEntity.getNombre(),clienteEntity.getApellidos());
		}
		
		
		return null;
	}
		
	//mappeo de todos los datos del cliente para poder mostrarlo en la tabla
	private ClienteEntity mapperClienteEntity(Cliente cliente, TrabajadorEntity trabajadorEntity) {
		ClienteEntity clienteEntity=new ClienteEntity();
		clienteEntity.setNombre(cliente.getNombre());
		clienteEntity.setApellidos(cliente.getApellidos());
		System.out.println(cliente.getApellidos());
		clienteEntity.setDni(cliente.getDni());
		clienteEntity.setTrabajador(trabajadorEntity);
		
		return clienteEntity;
	}


	private Collection<Cliente> mapperCliente(Collection<ClienteEntity> source){
		
		Collection<Cliente> result = new ArrayList<>();
		source.stream().forEach(cliente -> result.add(new Cliente(cliente.getId(), cliente.getDni(), cliente.getNombre(), cliente.getApellidos())));
		return result;
	}

}
