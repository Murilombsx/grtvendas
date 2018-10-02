package br.com.grtvendas.gerenciador;

import javax.inject.Inject;

import br.com.grtvendas.daos.UsuarioDao;
import br.com.grtvendas.models.Usuario;
import br.com.grtvendas.utilitarios.CriptografiaService;

public class UsuarioGerenciador {

	@Inject
	private UsuarioDao usuarioDao;
	
	public Usuario autentica(Usuario usuario) {
		usuario.setSenha(new CriptografiaService().criptografar(usuario.getSenha()));
		return usuarioDao.autentica(usuario);
	}

}
