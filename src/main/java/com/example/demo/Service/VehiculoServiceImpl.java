package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.IVehiculoRepository;
import com.example.demo.Repository.modelo.Vehiculo;
import com.example.demo.Service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired
	private IVehiculoRepository iVehiculoRepository;


	@Override
	public Vehiculo buscarPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.buscarPlaca(placa);
	}
	
	@Override
	public List<VehiculoTO> buscarTodos() {
		// TODO Auto-generated method stub
		List<Vehiculo> lista = this.iVehiculoRepository.buscarTodos();
		List<VehiculoTO> listaTO = lista.stream().map(vehiculo -> this.convertir(vehiculo)).collect(Collectors.toList());
		return listaTO;
	}
	
	private VehiculoTO convertir(Vehiculo vehiculo) {
		VehiculoTO vehi = new VehiculoTO();
		vehi.setId(vehiculo.getId());
		vehi.setPlaca(vehiculo.getPlaca());
		vehi.setAñoFabricacion(vehiculo.getAñoFabricacion());
		vehi.setColor(vehiculo.getColor());
		vehi.setMarca(vehiculo.getMarca());
		
		return vehi;
	}
	
	
	

}
