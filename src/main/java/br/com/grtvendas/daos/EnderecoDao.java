package br.com.grtvendas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.grtvendas.models.Endereco;

public class EnderecoDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void cadastrar(Endereco endereco) {
		manager.persist(endereco);
	}
	
	public List<Endereco> listar() {
		return manager.createQuery("select e from Endereco e", Endereco.class).getResultList();
	}
	
	public Endereco buscaPorId(int id) {
		return manager.createQuery("select e from Endereco e where e.id = :id", Endereco.class)
				.setParameter("id", id).getSingleResult();
	}

}
