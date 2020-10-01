package br.edu.unidep.apiseguranca.apiseguranca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_endereco")
	private Long codigo;
	
	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "rua")
	private String rua;
	
	
	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "estado")
	private String estado;
	
	
	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "número")
	private String numero;


	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_grupo")
	private Grupo grupo;


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	public Grupo getGrupo() {
		return grupo;
	}


	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


}
