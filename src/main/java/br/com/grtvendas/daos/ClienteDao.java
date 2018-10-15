package br.com.grtvendas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Representante;

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
		} catch (NoResultException e) {
			return manager.createQuery(
					"select c from Cliente c left join fetch c.pedidos where c.id = :id and c.pedidos is empty",
					Cliente.class).setParameter("id", id).getSingleResult();
		}
	}

	public Cliente buscaPorCNPJ(String cnpj) {
		try {
			try {
				return manager.createQuery("select c from Cliente c join fetch c.pedidos where c.cnpj = :cnpj", Cliente.class)
						.setParameter("cnpj", cnpj).getSingleResult();
			} catch (NoResultException e) {
			return manager.createQuery(
					"select c from Cliente c left join fetch c.pedidos where c.cnpj = :cnpj and c.pedidos is empty",
					Cliente.class).setParameter("cnpj", cnpj).getSingleResult();
			}
		} catch (NoResultException e) { // Retorna um cliente com id = 0, caso esse cliente nao esteja cadastrado no sistema
			Cliente cliente = new Cliente();
			cliente.setId(0);
			return cliente;
		}
	}

	public void remove(Cliente cliente) {
		Object c = manager.merge(cliente);
		Object e = manager.merge(cliente.getEndereco());
		manager.remove(e);
		manager.remove(c);
	}

	public void atualiza(Cliente cliente) {
		manager.merge(cliente.getEndereco());
		manager.merge(cliente);
	}

	public boolean existe(String cnpj) {
		Cliente cliente = buscaPorCNPJ(cnpj);
		if (cliente.getId() != 0) {
			return true;
		} else {
			return false;
		}
	}

	public Cliente buscaPorNome(String nome) {
		return manager.createQuery("select c from Cliente c where c.nomeFantasia = :nome", Cliente.class).setParameter("nome", nome).getSingleResult();
	}

}
