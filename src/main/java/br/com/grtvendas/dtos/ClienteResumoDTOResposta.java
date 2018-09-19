package br.com.grtvendas.dtos;

import br.com.grtvendas.models.Cliente;

/*
	Classe de visualização de Cliente resumida, que mostra:
		- id, nome fantasia, razão social e cnpj
*/

public class ClienteResumoDTOResposta {

	private Integer id;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;

	public ClienteResumoDTOResposta() {
	}

	public ClienteResumoDTOResposta(Integer id, String nomeFantasia, String razaoSocial, String cnpj) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public ClienteResumoDTOResposta transformaEmDTO(Cliente cliente) {

		return new ClienteResumoDTOResposta(cliente.getId(), cliente.getNomeFantasia(), cliente.getRazaoSocial(),
				cliente.getCnpj());
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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
