package br.com.grtvendas.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PedidoDao {
	
	@PersistenceContext
	private EntityManager manager;

}
