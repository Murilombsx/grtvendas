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

import br.com.grtvendas.dtos.ClienteDTO;
import br.com.grtvendas.dtos.ClienteDTOResposta;
import br.com.grtvendas.dtos.ClienteResumoDTOResposta;
import br.com.grtvendas.gerenciador.ClienteGerenciador;
import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Pedido;

@Path("/clientes")
@RequestScoped
public class ClienteService {

	@Inject
	private ClienteGerenciador clienteGerenciador;

	// Até o momento, onde foi testado, cumpriu sua função de cadastrar um cliente com eficiencia
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
	
	// Ainda não está funcionando
	/*@GET
	@Path("/detalhe/{idCliente}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteDTOResposta detalhe(@PathParam("idCliente") Integer idCliente) {
		Cliente clienteOriginalAuxiliar = clienteGerenciador.buscaPorId(idCliente);
		ClienteDTOResposta cliente = new ClienteDTOResposta().transformaEmDTO(clienteOriginalAuxiliar);
		
		return cliente;
	}*/

}
