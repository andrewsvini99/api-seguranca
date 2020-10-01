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


import br.edu.unidep.apiseguranca.apiseguranca.model.Produto;
import br.edu.unidep.apiseguranca.apiseguranca.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoRest {
	
	@Autowired
	ProdutoRepository repositorio;
	
	@GetMapping("/ok")
	public String ok() {
		return "ok";
	}

	@GetMapping
	public List<Produto> listar() {
		return repositorio.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto,
			HttpServletResponse response) {
		
		Produto produtoSalva = repositorio.save(produto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
				path("/{codigo}").buildAndExpand(
						produtoSalva.getCodigo()).toUri();
						
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(produtoSalva);
		
	}
	
	@GetMapping("/{codigo_produto}")
	public ResponseEntity<Produto> buscarPeloCodigo(
			@PathVariable Long codigo_produto) {
		
		Optional<Produto> produto = repositorio.findById(codigo_produto);
		
		return ResponseEntity.ok(produto.get());
	}
	
	@DeleteMapping("/{codigo_produto}")
	public void remover(@PathVariable Long codigo_produto) {
		Optional<Produto> produto = repositorio.findById(codigo_produto);
		if (produto.isPresent()) {
			repositorio.deleteById(codigo_produto);
		}
	}
}
