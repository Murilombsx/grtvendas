package br.com.grtvendas.dtos.resposta;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Endereco;

/*
	Classe de visualização de Cliente resumida, que mostra:
		- id, nome fantasia, cnpj e endereço
*/

public class ClienteResumoComEnderecoDTOResposta {

	private Integer id;
	private String nomeFantasia;
	private String cnpj;
	private Endereco endereco;

	public ClienteResumoComEnderecoDTOResposta() {
	}

	public ClienteResumoComEnderecoDTOResposta(Integer id, String nomeFantasia, String cnpj, Endereco endereco) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}

	public ClienteResumoComEnderecoDTOResposta transformaEmDTO(Cliente cliente) {
		return new ClienteResumoComEnderecoDTOResposta(cliente.getId(), cliente.getNomeFantasia(), cliente.getCnpj(),
				cliente.getEndereco());
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
