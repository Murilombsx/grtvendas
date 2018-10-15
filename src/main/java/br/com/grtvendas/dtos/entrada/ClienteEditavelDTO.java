package br.com.grtvendas.dtos.entrada;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Endereco;
import br.com.grtvendas.models.Representante;

/*
	Classe de inserção dos dados de um cliente, que filtra apenas os campos que deseja receber:
		- Alguns campos do cliente
		- Endereço do cliente
		- id e nome do representante
*/

public class ClienteEditavelDTO {

	private Integer id;
	private String nomeFantasia;
	private String pessoaContato;
	private String email;
	private String telefone;
	private Endereco endereco;
	private RepresentanteIdDTO representante;

	public Cliente transformaParaObjeto() {
		Representante representante = this.representante.transformaParaObjeto();
		return new Cliente(id, nomeFantasia, pessoaContato, email, telefone, endereco, representante);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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

	public RepresentanteIdDTO getRepresentante() {
		return representante;
	}

	public void setRepresentante(RepresentanteIdDTO representante) {
		this.representante = representante;
	}

}
