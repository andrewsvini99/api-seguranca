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


import br.edu.unidep.apiseguranca.apiseguranca.model.Grupo;
import br.edu.unidep.apiseguranca.apiseguranca.repository.GrupoRepository;

@RestController
@RequestMapping("/grupos")
public class GrupoRest {
	
	@Autowired
	GrupoRepository repositorio;
	
	@GetMapping("/ok")
	public String ok() {
		return "ok";
	}

	@GetMapping
	public List<Grupo> listar() {
		return repositorio.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Grupo> criar(@Valid @RequestBody Grupo grupo,
			HttpServletResponse response) {
		
		Grupo grupoSalva = repositorio.save(grupo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
				path("/{codigo}").buildAndExpand(
						grupoSalva.getCodigo()).toUri();
						
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(grupoSalva);
		
	}
	
	@GetMapping("/{codigo_grupo}")
	public ResponseEntity<Grupo> buscarPeloCodigo(
			@PathVariable Long codigo_grupo) {
		
		Optional<Grupo> grupo = repositorio.findById(codigo_grupo);
		
		return ResponseEntity.ok(grupo.get());
	}
	
	@DeleteMapping("/{codigo_grupo}")
	public void remover(@PathVariable Long codigo_grupo) {
		Optional<Grupo> grupo = repositorio.findById(codigo_grupo);
		if (grupo.isPresent()) {
			repositorio.deleteById(codigo_grupo);
		}
	}
}
