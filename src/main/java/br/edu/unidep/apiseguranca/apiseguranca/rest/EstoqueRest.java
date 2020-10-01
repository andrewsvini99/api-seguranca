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


import br.edu.unidep.apiseguranca.apiseguranca.model.Estoque;
import br.edu.unidep.apiseguranca.apiseguranca.repository.EstoqueRepository;

@RestController
@RequestMapping("/estoques")
public class EstoqueRest {
	
	@Autowired
	EstoqueRepository repositorio;
	
	@GetMapping("/ok")
	public String ok() {
		return "ok";
	}

	@GetMapping
	public List<Estoque> listar() {
		return repositorio.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Estoque> criar(@Valid @RequestBody Estoque estoque,
			HttpServletResponse response) {
		
		Estoque estoqueSalva = repositorio.save(estoque);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
				path("/{codigo}").buildAndExpand(
						estoqueSalva.getCodigo()).toUri();
						
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(estoqueSalva);
		
	}
	
	@GetMapping("/{codigo_estoque}")
	public ResponseEntity<Estoque> buscarPeloCodigo(
			@PathVariable Long codigo_estoque) {
		
		Optional<Estoque> estoque = repositorio.findById(codigo_estoque);
		
		return ResponseEntity.ok(estoque.get());
	}
	
	@DeleteMapping("/{codigo_estoque}")
	public void remover(@PathVariable Long codigo_estoque) {
		Optional<Estoque> estoque = repositorio.findById(codigo_estoque);
		if (estoque.isPresent()) {
			repositorio.deleteById(codigo_estoque);
		}
	}
}
