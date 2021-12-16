package com.app.tfg.repositories;


import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.tfg.entity.ServicioEntity;

public interface ServicioRepository extends JpaRepository<ServicioEntity, Integer>{

	//metodo para coger el id del cliente para mostrar los servicios
	Collection<ServicioEntity>findByCliente_Id(Integer id);
}
