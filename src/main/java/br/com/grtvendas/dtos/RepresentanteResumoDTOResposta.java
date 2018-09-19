package br.com.grtvendas.dtos;

import br.com.grtvendas.models.Representante;

/*
	Classe de visualização de Representante resumida, que mostra apenas:
		- id e nome do representante
*/

public class RepresentanteResumoDTOResposta {

	private Integer id;
	private String nome;

	public RepresentanteResumoDTOResposta() {
	}

	public RepresentanteResumoDTOResposta(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public RepresentanteResumoDTOResposta transformaEmDTO(Representante representante) {
		return new RepresentanteResumoDTOResposta(representante.getId(), representante.getNome());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
