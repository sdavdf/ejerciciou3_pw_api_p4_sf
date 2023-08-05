package com.example.demo.Repository;

import java.util.List;

import com.example.demo.Repository.modelo.Vehiculo;

public interface IVehiculoRepository {
	
	public List<Vehiculo> buscarTodos();
	
	public Vehiculo buscarPlaca(String placa);
}
