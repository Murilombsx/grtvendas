package br.com.grtvendas.dtos.resposta;

import br.com.grtvendas.models.Endereco;

/*
	Classe de visualização de Endereço resumida, que mostra apenas:
		- id e estado do endereço
*/

public class EnderecoResumoDTOResposta {

	private String estado;

	public EnderecoResumoDTOResposta() {
	}

	public EnderecoResumoDTOResposta(String estado) {
		this.estado = estado;
	}

	public EnderecoResumoDTOResposta transformaEmDTO(Endereco endereco) {
		return new EnderecoResumoDTOResposta(endereco.getEstado());
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
