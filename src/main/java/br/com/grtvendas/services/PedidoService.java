package br.com.grtvendas.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

import br.com.grtvendas.gerenciador.PedidoGerenciador;

@Path("/pedido")
@RequestScoped
public class PedidoService {
	
	@Inject
	private PedidoGerenciador pedidoGerenciador;
	
}
