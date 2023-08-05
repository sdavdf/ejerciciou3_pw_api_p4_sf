package com.example.demo.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.modelo.Vehiculo;
import com.example.demo.Service.IVehiculoService;
import com.example.demo.Service.to.VehiculoTO;


@RestController
@RequestMapping("/vehiculos")
public class VehiculoControllerRestful {
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	
	
	@GetMapping(path = "/{placa}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Vehiculo consultarPorCedula(@PathVariable String placa) {
		return this.iVehiculoService.buscarPlaca(placa);
	}
	
	@GetMapping(path = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoTO>> consultarTodosHATEOAS() {
		List<VehiculoTO> lista = this.iVehiculoService.buscarTodos();
		for(VehiculoTO v : lista) {
			Link myLink = linkTo(methodOn(VehiculoControllerRestful.class).consultarPorCedula(v.getPlaca())).withSelfRel();
			v.add(myLink);
			
		}
		
		
		return new ResponseEntity<>(lista, null, 200);

	}

}
