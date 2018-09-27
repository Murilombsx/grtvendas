package br.com.grtvendas.dtos.resposta;

import br.com.grtvendas.models.Representante;

/*
	Classe de visualização de Representante resumida, que mostra apenas:
		- id e nome do representante
*/

public class RepresentanteResumoRefinadoDTOResposta {

	private Integer id;
	private String nome;

	public RepresentanteResumoRefinadoDTOResposta() {
	}

	public RepresentanteResumoRefinadoDTOResposta(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public RepresentanteResumoRefinadoDTOResposta transformaEmDTO(Representante representante) {

		return new RepresentanteResumoRefinadoDTOResposta(representante.getId(), representante.getNome());
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
