package br.com.grtvendas.dtos.resposta;

import br.com.grtvendas.models.Cliente;

/*
	Classe de visualização de Cliente resumida, que mostra:
		- id, nome fantasia e cnpj
*/

public class ClienteResumoRefinadoDTOResposta {

	private Integer id;
	private String nomeFantasia;
	private String cnpj;

	public ClienteResumoRefinadoDTOResposta() {
	}

	public ClienteResumoRefinadoDTOResposta(Integer id, String nomeFantasia, String cnpj) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}

	public ClienteResumoRefinadoDTOResposta transformaEmDTO(Cliente cliente) {
		return new ClienteResumoRefinadoDTOResposta(cliente.getId(), cliente.getNomeFantasia(), cliente.getCnpj());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
