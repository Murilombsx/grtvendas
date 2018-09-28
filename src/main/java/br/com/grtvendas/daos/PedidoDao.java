package br.com.grtvendas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.grtvendas.models.Pedido;

public class PedidoDao {
	
	@PersistenceContext
	private EntityManager manager;

	public List<Pedido> listar() {
		return manager.createQuery("select p from Pedido p", Pedido.class).getResultList();
	}

	public Pedido buscaPorId(Integer id) {
		return manager.createQuery("select p from Pedido p where p.id = :id", Pedido.class)
				.setParameter("id", id).getSingleResult();
	}

	public void remove(Pedido pedido) {
		Object p = manager.merge(pedido);
		manager.remove(p);		
	}

	public void cadastrar(Pedido pedido) {
		manager.persist(pedido);
		
	}

	public int buscaUltimoNumeroDePedido() {
		List<Pedido> pedidos = manager.createQuery("select p from Pedido p", Pedido.class).getResultList();
		if(pedidos.size() == 0) {
			return 1;
		} else {
			Pedido ultimoPedido = pedidos.get(pedidos.size()-1);
			return ultimoPedido.getNumero() + 1;
		}
	}

	public void atualiza(Pedido pedido) {
		manager.merge(pedido);
	}

}
