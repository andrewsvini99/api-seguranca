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


import br.edu.unidep.apiseguranca.apiseguranca.model.Cliente;
import br.edu.unidep.apiseguranca.apiseguranca.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteRest {
	
	@Autowired
	ClienteRepository repositorio;
	
	@GetMapping("/ok")
	public String ok() {
		return "ok";
	}

	@GetMapping
	public List<Cliente> listar() {
		return repositorio.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente,
			HttpServletResponse response) {
		
		Cliente clienteSalva = repositorio.save(cliente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
				path("/{codigo}").buildAndExpand(
						clienteSalva.getCodigo()).toUri();
						
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(clienteSalva);
		
	}
	
	@GetMapping("/{codigo_cliente}")
	public ResponseEntity<Cliente> buscarPeloCodigo(
			@PathVariable Long codigo_cliente) {
		
		Optional<Cliente> cliente = repositorio.findById(codigo_cliente);
		
		return ResponseEntity.ok(cliente.get());
	}
	
	@DeleteMapping("/{codigo_cliente}")
	public void remover(@PathVariable Long codigo_cliente) {
		Optional<Cliente> cliente = repositorio.findById(codigo_cliente);
		if (cliente.isPresent()) {
			repositorio.deleteById(codigo_cliente);
		}
	}
	
	/*@AtualizarMapping("/{codigo_cliente}")
	public void atualizar(@PathVariable Long codigo_cliente) {
		Optional<Cliente> cliente = repositorio.findById(codigo_cliente);
		if (cliente.isPresent()) {
			repositorio.deleteById(codigo_cliente);
		}
	}*/
	
}
