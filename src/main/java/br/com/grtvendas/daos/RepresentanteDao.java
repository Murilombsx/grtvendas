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

}
