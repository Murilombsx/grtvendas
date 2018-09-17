package br.com.grtvendas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.grtvendas.models.Cliente;

public class ClienteDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void cadastrar(Cliente cliente) {
		manager.persist(cliente);
	}
	
	public List<Cliente> listar() {
		return manager.createQuery("select c.id as idCliente, c.cnpj as cnpjCliente, c.nomeFantasia as nomeFantasiaCliente," + 
				" r.id as idRepresentante, r.nome as nomeRepresentante," + 
				" p.id as idPedido, p.numero as numeroPedido" + 
				" from Cliente c INNER JOIN c.Representante r ON r.id = c.representante_id" + 
				" INNER JOIN c.Pedido p ON p.cliente_id = c.id", Cliente.class).getResultList();
	}

}
