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


import br.edu.unidep.apiseguranca.apiseguranca.model.Endereco;
import br.edu.unidep.apiseguranca.apiseguranca.repository.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoRest {
	
	@Autowired
	EnderecoRepository repositorio;
	
	@GetMapping("/ok")
	public String ok() {
		return "ok";
	}

	@GetMapping
	public List<Endereco> listar() {
		return repositorio.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Endereco> criar(@Valid @RequestBody Endereco endereco,
			HttpServletResponse response) {
		
		Endereco enderecoSalva = repositorio.save(endereco);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
				path("/{codigo}").buildAndExpand(
						enderecoSalva.getCodigo()).toUri();
						
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(enderecoSalva);
		
	}
	
	@GetMapping("/{codigo_endereco}")
	public ResponseEntity<Endereco> buscarPeloCodigo(
			@PathVariable Long codigo_endereco) {
		
		Optional<Endereco> endereco = repositorio.findById(codigo_endereco);
		
		return ResponseEntity.ok(endereco.get());
	}
	
	@DeleteMapping("/{codigo_endereco}")
	public void remover(@PathVariable Long codigo_endereco) {
		Optional<Endereco> endereco = repositorio.findById(codigo_endereco);
		if (endereco.isPresent()) {
			repositorio.deleteById(codigo_endereco);
		}
	}
}
