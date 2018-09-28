package br.com.grtvendas.gerenciador;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.grtvendas.daos.PedidoDao;
import br.com.grtvendas.dtos.entrada.PedidoEditavelDTO;
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

	@Transactional
	public Pedido cadastrar(Pedido pedido) {

		if (pedido.getCliente().getId() == null) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
					.entity("É necessário ter um cliente associado ao pedido").build());
		}

		if (pedido.getRepresentante().getId() == null) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
					.entity("É necessário ter um representante associado ao pedido").build());
		}

		int numero = pedidoDao.buscaUltimoNumeroDePedido();
		pedido.setNumero(numero);

		if (pedido.getNumero() == 0 || pedido.getQtdePecas() == 0 || pedido.getValorTotal().toString().trim().equals("")
				|| pedido.getValorTotal().toString() != "0") {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
					.entity("Campos obrigatórios não foram preenchidos").build());
		} else {
			pedidoDao.cadastrar(pedido);
		}

		return pedido;
	}
	
	@Transactional
	public void atualiza(Pedido pedido, PedidoEditavelDTO pedidoEditavelDTO) {
		if ((pedido.getQtdePecas() != pedidoEditavelDTO.getQtdePecas()) && (pedidoEditavelDTO.getQtdePecas() != 0)) {
			pedido.setQtdePecas(pedidoEditavelDTO.getQtdePecas());
		}

		if ((pedido.getValorTotal() != pedidoEditavelDTO.getValorTotal())
				&& (pedidoEditavelDTO.getValorTotal().toString() != "0") && (!pedidoEditavelDTO.getValorTotal().toString().trim().equals(""))) {
			pedido.setValorTotal(pedidoEditavelDTO.getValorTotal());
		}

		if ((pedido.getObservacao() != pedidoEditavelDTO.getObservacao())
				&& (pedidoEditavelDTO.getObservacao() != null)
				&& (!pedidoEditavelDTO.getObservacao().trim().equals(""))) {
			pedido.setObservacao(pedidoEditavelDTO.getObservacao());
		}

		pedidoDao.atualiza(pedido);
	}

}
