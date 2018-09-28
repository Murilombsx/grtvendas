package br.com.grtvendas.gerenciador;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.grtvendas.daos.PedidoDao;
import br.com.grtvendas.models.Pedido;

public class PedidoGerenciador {
	
	@Inject
	private PedidoDao pedidoDao;

	public List<Pedido> todosPedidos() {
		return pedidoDao.listar();
	}

	public Pedido buscaPorId(Integer id) {
		return pedidoDao.buscaPorId(id);
	}

	@Transactional
	public void remove(Pedido pedido) {
		pedidoDao.remove(pedido);
	}
	
}
