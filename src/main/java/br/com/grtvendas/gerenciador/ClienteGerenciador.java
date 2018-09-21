package br.com.grtvendas.gerenciador;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.grtvendas.daos.ClienteDao;
import br.com.grtvendas.daos.EnderecoDao;
import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Endereco;

public class ClienteGerenciador {

	@Inject
	private ClienteDao clienteDao;
	@Inject
	private EnderecoDao enderecoDao;

	// Um cliente obrigatoriamente, deve ter em seu cadastro: um endereço e um
	// representante associado
	// obs.: representante ja esta persistido no BD, para criar um cliente o
	// representante ja tem que existir no BD
	@Transactional
	public Cliente cadastrar(Cliente cliente) {

		if (cliente.getRepresentante().getId() == null) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
					.entity("É necessário ter um representante associado ao cliente").build());
		}

		Endereco endereco = cliente.getEndereco();

		if (endereco.getRua() == null || endereco.getRua().trim().equals("") || endereco.getNumero() == null
				|| endereco.getNumero().trim().equals("") || endereco.getBairro() == null
				|| endereco.getBairro().trim().equals("") || endereco.getCidade() == null
				|| endereco.getCidade().trim().equals("") || endereco.getEstado() == null
				|| endereco.getEstado().trim().equals("") || endereco.getCep() == null
				|| endereco.getCep().trim().equals("")) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
					.entity("Campos obrigatórios de endereço não foram preenchidos").build());
		} else {
			enderecoDao.cadastrar(endereco);
		}

		if (cliente.getCnpj() == null || cliente.getCnpj().trim().equals("") || cliente.getInscricaoEstadual() == null
				|| cliente.getInscricaoEstadual().trim().equals("") || cliente.getEmail() == null
				|| cliente.getEmail().trim().equals("") || cliente.getRazaoSocial() == null
				|| cliente.getRazaoSocial().trim().equals("") || cliente.getTelefone() == null
				|| cliente.getTelefone().trim().equals("") || cliente.getPessoaContato() == null
				|| cliente.getPessoaContato().trim().equals("")) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
					.entity("Campos obrigatórios não foram preenchidos").build());
		} else {
			clienteDao.cadastrar(cliente);
		}
		return cliente;
	}

	public List<Cliente> todosClientes() {
		return clienteDao.listar();
	}

	public Cliente buscaPorId(int id) {
		return clienteDao.buscaPorId(id);
	}
	
	@Transactional
	public void remove(Cliente cliente) {
		if (cliente.getPedidos().get(0) != null) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
					.entity("Não é possível remover um cliente com pedidos cadastrados").build());
		} else {
			clienteDao.remove(cliente);
		}

	}

}
