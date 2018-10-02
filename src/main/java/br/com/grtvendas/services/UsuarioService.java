package br.com.grtvendas.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.grtvendas.dtos.entrada.UsuarioDTO;
import br.com.grtvendas.gerenciador.UsuarioGerenciador;

@Path("/usuario")
@RequestScoped
public class UsuarioService {

	@Inject
	private UsuarioGerenciador usuarioGerenciador;

	// Funcionando ok
	// Autentica um usuário
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(UsuarioDTO usuarioDTO) {
		usuarioGerenciador.autentica(usuarioDTO.transformaParaObjeto());

		return Response.status(Response.Status.OK).build();
	}

	
}
