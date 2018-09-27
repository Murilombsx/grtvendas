package br.com.grtvendas.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.grtvendas.dtos.resposta.PedidoResumoDTOResposta;
import br.com.grtvendas.gerenciador.PedidoGerenciador;
import br.com.grtvendas.models.Pedido;

@Path("/pedidos")
@RequestScoped
public class PedidoService {

	@Inject
	private PedidoGerenciador pedidoGerenciador;

	// Funcionando ok
	// Lista todos pedidos de forma resumida
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PedidoResumoDTOResposta> listar() {
		List<Pedido> pedidosOriginalAuxiliar = pedidoGerenciador.todosPedidos();
		List<PedidoResumoDTOResposta> pedidos = new ArrayList<>();
		for (Pedido pedidoOriginalAuxiliar : pedidosOriginalAuxiliar) {
			PedidoResumoDTOResposta pedido = new PedidoResumoDTOResposta().transformaEmDTO(pedidoOriginalAuxiliar);
			pedidos.add(pedido);
		}

		return pedidos;
	}

}
