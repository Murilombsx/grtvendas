package br.com.grtvendas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.grtvendas.models.Cliente;

public class ClienteDao {

	@PersistenceContext
	private EntityManager manager;

	public void cadastrar(Cliente cliente) {
		manager.persist(cliente);
	}

	public List<Cliente> listar() {
		return manager.createQuery("select c from Cliente c", Cliente.class).getResultList();
	}

	public Cliente buscaPorId(int id) {
		try {
			return manager.createQuery("select c from Cliente c join fetch c.pedidos where c.id = :id", Cliente.class)
				.setParameter("id", id).getSingleResult();
		} catch(NoResultException e) {
			return manager.createQuery("select c from Cliente c left join fetch c.pedidos where c.id = :id and c.pedidos is empty", Cliente.class)
					.setParameter("id", id).getSingleResult();
		}
	}

	public void remove(Cliente cliente) {
		Object c= manager.merge(cliente);
		manager.remove(c);
	}

}
