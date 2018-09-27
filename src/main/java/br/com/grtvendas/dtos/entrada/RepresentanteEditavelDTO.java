package br.com.grtvendas.dtos.entrada;

import br.com.grtvendas.models.Endereco;
import br.com.grtvendas.models.Representante;

/*
	Classe de inserção dos dados de um representante, que filtra apenas os campos que deseja receber:
		- Alguns campos do representante
		- Endereço do representante
*/

public class RepresentanteEditavelDTO {

	private Integer id;
	private String email;
	private String telefone;
	private Endereco endereco;

	public Representante transformaParaObjeto() {
		return new Representante(id, email, telefone, endereco);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
