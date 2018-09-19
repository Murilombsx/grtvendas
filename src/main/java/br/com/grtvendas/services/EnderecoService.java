package br.com.grtvendas.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.grtvendas.gerenciador.EnderecoGerenciador;
import br.com.grtvendas.models.Endereco;

@Path("/endereco")
@RequestScoped
public class EnderecoService {

	@Inject
	private EnderecoGerenciador enderecoGerenciador;
	
	// FUNCIONANDO OK
	@GET
	@Path("/descricao/{idEndereco}")
	@Produces(MediaType.APPLICATION_JSON)
	public Endereco descricao(@PathParam("idEndereco") Integer idEndereco) {
		return enderecoGerenciador.buscaPorId(idEndereco);
	}

	// FUNCIONANDO OK
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Endereco> descricao() {
		return enderecoGerenciador.todosEnderecos();
	}

}
