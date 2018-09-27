package br.com.grtvendas.gerenciador;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.grtvendas.daos.RepresentanteDao;
import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Pedido;
import br.com.grtvendas.models.Representante;

public class RepresentanteGerenciador{
	
	@Inject
	private RepresentanteDao representanteDao;

	public List<Representante> todosRepresentantes() {
		return representanteDao.listar();
	}

	public Representante buscaPorId(Integer id) {
		return representanteDao.buscaPorId(id);
	}
	
	@Transactional
	public void remove(Representante representante) {
		Set<Pedido> pedidos = representante.getPedidos();
		Set<Cliente> clientes = representante.getClientes();
		if (!pedidos.isEmpty() || !clientes.isEmpty()) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
					.entity("Não é possível remover um representante com um cliente ou pedido associado").build());
		} else {
			representanteDao.remove(representante);
		}
		
	}
	
}
