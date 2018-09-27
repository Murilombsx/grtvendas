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

}
