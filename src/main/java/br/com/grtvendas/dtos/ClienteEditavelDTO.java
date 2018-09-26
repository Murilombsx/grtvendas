package br.com.grtvendas.dtos;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Endereco;
import br.com.grtvendas.models.Representante;

public class ClienteEditavelDTO {

	private Integer id;
	private String nomeFantasia;
	private String pessoaContato;
	private String email;
	private String telefone;
	private Endereco endereco;
	private RepresentanteDTO representante;

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

	public RepresentanteDTO getRepresentante() {
		return representante;
	}

	public void setRepresentante(RepresentanteDTO representante) {
		this.representante = representante;
	}

}
