package br.com.grtvendas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.grtvendas.models.Representante;

public class RepresentanteDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Representante> listar() {
		return manager.createQuery("select r from Representante r", Representante.class).getResultList();
	}

	public Representante buscaPorId(Integer id) {
		try {
			return manager.createQuery(
					"select r from Representante r join fetch r.clientes join fetch r.pedidos where r.id = :id",
					Representante.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return manager.createQuery(
					"select r from Representante r left join fetch r.clientes left join fetch r.pedidos where r.id = :id and r.clientes is empty or r.pedidos is empty",
					Representante.class).setParameter("id", id).getSingleResult();
		}
	}

	public void remove(Representante representante) {
		Object r = manager.merge(representante);
		Object e = manager.merge(representante.getEndereco());
		manager.remove(e);
		manager.remove(r);
	}

	public void cadastrar(Representante representante) {
		manager.persist(representante);
	}

	public void atualiza(Representante representante) {
		manager.merge(representante.getEndereco());
		manager.merge(representante);
	}

	public Representante buscaPorCNPJ(String cnpj) {
		try {
			try {
				return manager.createQuery("select r from Representante r join fetch r.clientes join fetch r.pedidos where r.cnpj = :cnpj", Representante.class)
						.setParameter("cnpj", cnpj).getSingleResult();
			} catch (NoResultException e) {
			return manager.createQuery(
					"select r from Representante r left join fetch r.clientes left join fetch r.pedidos where r.cnpj = :cnpj and r.clientes is empty and r.pedidos is empty",
					Representante.class).setParameter("cnpj", cnpj).getSingleResult();
			}
		} catch (NoResultException e) { // Retorna um representante com id = 0, caso esse representante nao esteja cadastrado no sistema
			Representante representante = new Representante();
			representante.setId(0);
			return representante;
		}
	}
	
	public boolean existe(String cnpj) {
		Representante representante = buscaPorCNPJ(cnpj);
		if (representante.getId() != 0) {
			return true;
		} else {
			return false;
		}
	}

}
