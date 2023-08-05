package com.example.demo.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Vehiculo> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
		return myQuery.getResultList();
	}
	
	public Vehiculo buscarPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vehiculo.class, placa);
	}

}
