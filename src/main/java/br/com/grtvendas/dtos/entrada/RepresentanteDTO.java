package br.com.grtvendas.dtos.entrada;

import br.com.grtvendas.models.Endereco;
import br.com.grtvendas.models.Representante;

/*
	Classe de inserção dos dados de um representante, que filtra apenas os campos que deseja receber:
		- Todas informações do representante (menos id)
		- Endereço do representante
*/

public class RepresentanteDTO {

	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private String razaoSocial;
	private String cnpj;
	private String telefone;
	private EnderecoDTO endereco;

	public Representante transformaParaObjeto() {
		Endereco endereco = this.endereco.transformaParaObjeto();
		return new Representante(nome, razaoSocial, cnpj, cpf, rg, email, telefone, endereco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

}
