package com.example.demo.Service.to;
import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class VehiculoTO extends RepresentationModel<VehiculoTO> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	private String placa;

	private String añoFabricacion;
	
	private String color;
	
	private String marca;

	
	//SET & GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAñoFabricacion() {
		return añoFabricacion;
	}

	public void setAñoFabricacion(String añoFabricacion) {
		this.añoFabricacion = añoFabricacion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	
	
	
	

}
