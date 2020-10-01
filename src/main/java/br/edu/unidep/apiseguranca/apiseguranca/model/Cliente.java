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
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_cliente")
	private Long codigo;
	
	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "sobrenome")
	private String sobrenome;
	
	
	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "idade")
	private String idade;
	
	
	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "sexo")
	private String sexo;
	
	
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


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getIdade() {
		return idade;
	}


	public void setIdade(String idade) {
		this.idade = idade;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
