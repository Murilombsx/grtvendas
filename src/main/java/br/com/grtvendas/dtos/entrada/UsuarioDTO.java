package br.com.grtvendas.dtos.entrada;

import br.com.grtvendas.models.Usuario;

/*
	Classe de login de um usuario
*/

public class UsuarioDTO {

	private String email;
	private String senha;

	public Usuario transformaParaObjeto() {
		return new Usuario(email, senha);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
