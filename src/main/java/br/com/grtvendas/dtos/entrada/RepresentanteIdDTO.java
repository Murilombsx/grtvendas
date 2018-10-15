package br.com.grtvendas.dtos.entrada;

import br.com.grtvendas.models.Representante;

public class RepresentanteIdDTO {

	private Integer id;

	public Representante transformaParaObjeto() {
		return new Representante(id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
