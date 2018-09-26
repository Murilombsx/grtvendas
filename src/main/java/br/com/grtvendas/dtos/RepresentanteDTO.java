package br.com.grtvendas.dtos;

import br.com.grtvendas.models.Representante;

public class RepresentanteDTO {

	private Integer id;
	private String nome;

	public Representante transformaParaObjeto() {
		return new Representante(id, nome);
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
