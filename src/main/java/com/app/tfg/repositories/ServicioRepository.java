package com.app.tfg.repositories;


import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.tfg.entity.ServicioEntity;

public interface ServicioRepository extends JpaRepository<ServicioEntity, Integer>{

	Collection<ServicioEntity>findByCliente_Id(Integer id);
}
