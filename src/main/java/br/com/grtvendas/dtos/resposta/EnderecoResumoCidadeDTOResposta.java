package br.com.grtvendas.dtos.resposta;

import br.com.grtvendas.models.Endereco;

/*
	Classe de visualização de Endereço resumida, que mostra apenas:
		- id e cidade do endereço
*/

public class EnderecoResumoCidadeDTOResposta {

	private String cidade;

	public EnderecoResumoCidadeDTOResposta() {
	}

	public EnderecoResumoCidadeDTOResposta(String cidade) {
		this.cidade = cidade;
	}

	public EnderecoResumoCidadeDTOResposta transformaEmDTO(Endereco endereco) {
		return new EnderecoResumoCidadeDTOResposta(endereco.getCidade());
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
