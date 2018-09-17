package br.com.grtvendas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.grtvendas.models.Representante;

public class RepresentanteDao {
	
	@PersistenceContext
	private EntityManager manager;

	/*public List<Representante> listar() {
		return manager.createQuery("select c.id as idCliente, c.nomeFantasia as nomeFantasiaCliente," + 
				" r.id as idRepresentante, r.nome as nomeRepresentante," + 
				" p.id as idPedido, p.numero as numeroPedido" + 
				" from Representante r INNER JOIN r.Cliente c ON c.representante_id = r.id" + 
				" INNER JOIN r.Pedido p ON p.representante_id = r.id", Representante.class).getResultList();
	}*/

	public Representante buscaPorId(int idRepresentante) {
		return manager.createQuery("select r from Representante r where r.id = :idRepresentante", Representante.class)
				.setParameter("idRepresentante", idRepresentante).getSingleResult();
	}
	
	

}
