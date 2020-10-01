package br.edu.unidep.apiseguranca.apiseguranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unidep.apiseguranca.apiseguranca.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
