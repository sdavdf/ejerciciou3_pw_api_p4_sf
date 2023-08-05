package com.example.demo.Service;

import java.util.List;

import com.example.demo.Repository.modelo.Vehiculo;
import com.example.demo.Service.to.VehiculoTO;

public interface IVehiculoService {
	
	public List<VehiculoTO> buscarTodos();
	
	public Vehiculo buscarPlaca(String placa);

}
