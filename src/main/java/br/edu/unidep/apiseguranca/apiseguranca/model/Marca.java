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
@Table(name = "marca")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_marca")
	private Long codigo;
	
	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "nome")
	private String nome;
	
	
	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "tipo")
	private String tipo;
	
	
	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "fabrica")
	private String fabrica;
	
	
	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "valor")
	private String valor;
	
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
	
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFabrica() {
		return fabrica;
	}

	public void setFabrica(String fabrica) {
		this.fabrica = fabrica;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
