package br.com.grtvendas.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.grtvendas.dtos.ClienteDTO;
import br.com.grtvendas.dtos.ClienteDTOResposta;
import br.com.grtvendas.dtos.ClienteResumoDTOResposta;
import br.com.grtvendas.gerenciador.ClienteGerenciador;
import br.com.grtvendas.models.Cliente;

@Path("/clientes")
@RequestScoped
public class ClienteService {

	@Inject
	private ClienteGerenciador clienteGerenciador;

	// Funcionando ok
	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteDTOResposta cadastrar(ClienteDTO clienteDTO) {
		Cliente clienteOriginalAuxiliar = clienteGerenciador.cadastrar(clienteDTO.transformaParaObjeto());
		ClienteDTOResposta cliente = new ClienteDTOResposta().transformaEmDTO(clienteOriginalAuxiliar);

		return cliente;
	}

	// Funcionando ok
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteResumoDTOResposta> listar() {
		List<Cliente> clientesOriginalAuxiliar = clienteGerenciador.todosClientes();
		List<ClienteResumoDTOResposta> clientes = new ArrayList<>();
		for (Cliente clienteOriginalAuxiliar : clientesOriginalAuxiliar) {
			ClienteResumoDTOResposta cliente = new ClienteResumoDTOResposta().transformaEmDTO(clienteOriginalAuxiliar);
			clientes.add(cliente);
		}

		return clientes;
	}

	// Funcionando ok
	@GET
	@Path("/detalhe/{idCliente}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteDTOResposta detalhe(@PathParam("idCliente") Integer idCliente) {
		Cliente clienteOriginalAuxiliar = clienteGerenciador.buscaPorId(idCliente);
		ClienteDTOResposta cliente = new ClienteDTOResposta().transformaEmDTO(clienteOriginalAuxiliar);

		return cliente;
	}

	// Funcionando ok
	@GET
	@Path("/deletar/{idCliente}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("idCliente") Integer idCliente) {
		Cliente cliente = clienteGerenciador.buscaPorId(idCliente);
		clienteGerenciador.remove(cliente);

		return Response.status(Response.Status.OK).entity("Cliente " + cliente.getCnpj() + " deletado com sucesso!")
				.build();
	}
}
