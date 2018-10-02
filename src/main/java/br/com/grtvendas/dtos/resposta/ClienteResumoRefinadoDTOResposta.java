package br.com.grtvendas.dtos.resposta;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Endereco;

/*
	Classe de visualização de Cliente resumida, que mostra:
		- id, nome fantasia, cnpj e cidade
*/

public class ClienteResumoRefinadoDTOResposta {

	private Integer id;
	private String nomeFantasia;
	private String cnpj;
	private EnderecoResumoCidadeDTOResposta endereco;

	public ClienteResumoRefinadoDTOResposta() {
	}

	public ClienteResumoRefinadoDTOResposta(Integer id, String nomeFantasia, String cnpj,
			EnderecoResumoCidadeDTOResposta endereco) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}

	public ClienteResumoRefinadoDTOResposta transformaEmDTO(Cliente cliente) {
		Endereco enderecoOriginalAuxiliar = cliente.getEndereco();
		EnderecoResumoCidadeDTOResposta endereco = new EnderecoResumoCidadeDTOResposta()
				.transformaEmDTO(enderecoOriginalAuxiliar);

		return new ClienteResumoRefinadoDTOResposta(cliente.getId(), cliente.getNomeFantasia(), cliente.getCnpj(),
				endereco);
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

	public EnderecoResumoCidadeDTOResposta getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoResumoCidadeDTOResposta endereco) {
		this.endereco = endereco;
	}

}
