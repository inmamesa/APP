package com.app.tfg.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.app.tfg.controller.data_table.DataTableObjectServicio;
import com.app.tfg.dominio.Cliente;
import com.app.tfg.dominio.Servicio;
import com.app.tfg.entity.ClienteEntity;
import com.app.tfg.entity.ServicioEntity;
import com.app.tfg.entity.TrabajadorEntity;
import com.app.tfg.repositories.ClienteRepository;
import com.app.tfg.repositories.ServicioRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private ServicioRepository servicioRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping(value="/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
	public DataTableObjectServicio findCliente(Integer id){
		
		System.out.println("ClienteController.id: "+id);
		ClienteEntity result = clienteRepository.findById(id).stream().findFirst().orElse(null);		
		//Collection<ServicioEntity> result= servicioRepository.findByCliente_Id(id);		
		
		DataTableObjectServicio dto= new DataTableObjectServicio();
		if(Objects.nonNull(result)) {
			dto.setData(this.mapperServicio(result.getServicioCollection()));
		}else {
			dto.setData(Collections.emptyList());
		}
		return dto;
		
		
	}
    private Collection<Servicio> mapperServicio(Collection<ServicioEntity> source){
		
		Collection<Servicio> result = new ArrayList<>();
		source.stream().forEach(servicio -> result.add(new Servicio(servicio.getCodServicio(), servicio.getTipoServicio())));
		return result;
	}


}
