package br.com.grtvendas.dtos;

import java.util.List;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Endereco;
import br.com.grtvendas.models.Pedido;
import br.com.grtvendas.models.Representante;

public class ClienteDTO {

	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	private String pessoaContato;
	private String email;
	private String telefone;
	private EnderecoDTO endereco;
	private Representante representante;
	private List<Pedido> pedidos;

	public Cliente transformaParaObjeto() {
		Endereco endereco = this.endereco.transformaParaObjeto();
		return new Cliente(nomeFantasia, razaoSocial, cnpj, inscricaoEstadual, pessoaContato, email, telefone, endereco,
				representante, pedidos);
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
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

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
