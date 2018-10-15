package br.com.grtvendas.dtos.entrada;

import br.com.grtvendas.models.Cliente;

public class ClienteIdDTO {

	private Integer id;

	public Cliente transformaParaObjeto() {
		return new Cliente(id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
