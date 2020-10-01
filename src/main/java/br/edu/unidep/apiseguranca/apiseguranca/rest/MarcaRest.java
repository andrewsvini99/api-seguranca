package br.edu.unidep.apiseguranca.apiseguranca.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import br.edu.unidep.apiseguranca.apiseguranca.model.Marca;
import br.edu.unidep.apiseguranca.apiseguranca.repository.MarcaRepository;

@RestController
@RequestMapping("/marcas")
public class MarcaRest {
	
	@Autowired
	MarcaRepository repositorio;
	
	@GetMapping("/ok")
	public String ok() {
		return "ok";
	}

	@GetMapping
	public List<Marca> listar() {
		return repositorio.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Marca> criar(@Valid @RequestBody Marca marca,
			HttpServletResponse response) {
		
		Marca marcaSalva = repositorio.save(marca);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
				path("/{codigo}").buildAndExpand(
						marcaSalva.getCodigo()).toUri();
						
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(marcaSalva);
		
	}
	
	@GetMapping("/{codigo_marca}")
	public ResponseEntity<Marca> buscarPeloCodigo(
			@PathVariable Long codigo_marca) {
		
		Optional<Marca> marca = repositorio.findById(codigo_marca);
		
		return ResponseEntity.ok(marca.get());
	}
	
	@DeleteMapping("/{codigo_marca}")
	public void remover(@PathVariable Long codigo_marca) {
		Optional<Marca> marca = repositorio.findById(codigo_marca);
		if (marca.isPresent()) {
			repositorio.deleteById(codigo_marca);
		}
	}
}
