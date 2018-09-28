package br.com.grtvendas.dtos.resposta;

import br.com.grtvendas.models.Endereco;
import br.com.grtvendas.models.Representante;

/*
	Classe de visualização de Representante resumida, que mostra apenas:
		- id, nome do representante e estado
*/

public class RepresentanteResumoDTOResposta {

	private Integer id;
	private String nome;
	private EnderecoResumoDTOResposta endereco;

	public RepresentanteResumoDTOResposta() {
	}

	public RepresentanteResumoDTOResposta(Integer id, String nome, EnderecoResumoDTOResposta endereco) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}

	public RepresentanteResumoDTOResposta transformaEmDTO(Representante representante) {
		Endereco enderecoOriginalAuxiliar = representante.getEndereco();
		EnderecoResumoDTOResposta endereco = new EnderecoResumoDTOResposta().transformaEmDTO(enderecoOriginalAuxiliar);

		return new RepresentanteResumoDTOResposta(representante.getId(), representante.getNome(), endereco);
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

	public EnderecoResumoDTOResposta getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoResumoDTOResposta endereco) {
		this.endereco = endereco;
	}

}
