package br.edu.unidep.apiseguranca.apiseguranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.apiseguranca.apiseguranca.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
