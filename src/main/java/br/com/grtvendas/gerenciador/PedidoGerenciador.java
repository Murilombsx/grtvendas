package br.com.grtvendas.gerenciador;

import java.util.List;

import javax.inject.Inject;

import br.com.grtvendas.daos.PedidoDao;
import br.com.grtvendas.models.Pedido;

public class PedidoGerenciador {
	
	@Inject
	private PedidoDao pedidoDao;

	public List<Pedido> todosPedidos() {
		return pedidoDao.listar();
	}
	
}
