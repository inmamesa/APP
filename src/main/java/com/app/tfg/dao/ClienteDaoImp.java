package com.app.tfg.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.tfg.entity.ClienteEntity;


@Repository
//@Transactional
public class ClienteDaoImp implements ClienteDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private static final String query="FROM cliente WHERE nombre = :nombre AND dnic = :dnic";
	
	@Override
	public boolean verificarCredenciales(ClienteEntity cliente){
		
		return entityManager.createQuery(query)
				.setParameter("nombre", cliente.getNombre())
				.setParameter("dnic",cliente.getDni())
				.getResultList().stream().findAny().isPresent();
		

     }

}
