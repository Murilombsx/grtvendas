package br.com.grtvendas.dtos.entrada;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Endereco;
import br.com.grtvendas.models.Representante;

/*
	Classe de inserção dos dados de um cliente, que filtra apenas os campos que deseja receber:
		- Todas informações do cliente (menos id)
		- Endereço do cliente
		- id e nome do representante
*/

public class ClienteDTO {

	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	private String pessoaContato;
	private String email;
	private String telefone;
	private EnderecoDTO endereco;
	private RepresentanteResumoDTO representante;

	public Cliente transformaParaObjeto() {
		Endereco endereco = this.endereco.transformaParaObjeto();
		Representante representante = this.representante.transformaParaObjeto();
		return new Cliente(nomeFantasia, razaoSocial, cnpj, inscricaoEstadual, pessoaContato, email, telefone, endereco,
				representante);
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

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getPessoaContato() {
		return pessoaContato;
	}

	public void setPessoaContato(String pessoaContato) {
		this.pessoaContato = pessoaContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public RepresentanteResumoDTO getRepresentante() {
		return representante;
	}

	public void setRepresentante(RepresentanteResumoDTO representante) {
		this.representante = representante;
	}

}
