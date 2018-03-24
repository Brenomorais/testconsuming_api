package com.breno.postrest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarroResource {

	private Map<Integer, Carro> carros;

	public CarroResource() {
		carros = new HashMap<Integer, Carro>();

		Carro c1 = new Carro(1, "Palio", "Fiat");
		Carro c2 = new Carro(2, "Gol", "Volks");
		Carro c3 = new Carro(3, "Onix", "GM");
		Carro c4 = new Carro(4, "Sandero", "Renault");
		Carro c5 = new Carro(5, "HB20", "Hyundai");
		Carro c6 = new Carro(6, "C3", "Citroen");

		carros.put(1, c1);
		carros.put(2, c2);
		carros.put(3, c3);
		carros.put(4, c4);
		carros.put(5, c5);
		carros.put(6, c6);
	}

	@RequestMapping(value = "/")
	public String Hello() {
		return "Hello API";
	}

	Integer cont = 0;
	
	@RequestMapping(value = "/carros", method = RequestMethod.GET)
	public ResponseEntity<List<Carro>> listar() {
		cont++;
		System.out.println(">> "+cont);
		return new ResponseEntity<List<Carro>>(new ArrayList<Carro>(carros.values()), HttpStatus.OK);
	}

	@RequestMapping(value = "/carros/{id}", method = RequestMethod.GET)
	public ResponseEntity<Carro> buscar(@PathVariable("id") Integer id) {
		Carro carro = carros.get(id);

		if (carro == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Carro>(carro, HttpStatus.OK);
	}

	@RequestMapping(value = "/carros/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable("id") int id) {
		Carro carro = carros.remove(id);

		if (carro == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
