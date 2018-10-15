package br.com.grtvendas.dtos.resposta;

import br.com.grtvendas.models.Endereco;

public class EnderecoResumoEstadoDTOResposta {

	private String estado;

	public EnderecoResumoEstadoDTOResposta() {
	}

	public EnderecoResumoEstadoDTOResposta(String estado) {
		this.estado = estado;
	}

	public EnderecoResumoEstadoDTOResposta transformaEmDTO(Endereco endereco) {
		return new EnderecoResumoEstadoDTOResposta(endereco.getEstado());
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
