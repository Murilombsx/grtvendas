package br.com.grtvendas.gerenciador;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.grtvendas.daos.ClienteDao;
import br.com.grtvendas.daos.EnderecoDao;
import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Endereco;
import br.com.grtvendas.models.Representante;

public class ClienteGerenciador {
	
	@Inject
	private ClienteDao clienteDao;
	@Inject
	private EnderecoDao enderecoDao;
	
	// Metodo responsavel por cadastrar um cliente no BD
	// Um cliente obrigatoriamente, deve ter em seu cadastro: um endereço e um representante associado
	// obs.: representante ja esta persistido no BD, para criar um cliente o representante ja tem que existir no BD
	@Transactional
	public void cadastrar(Cliente cliente, Endereco endereco, Integer idRepresentante) {
		cliente.setEndereco(endereco); // guarda o endereco dentro do cliente
		cliente.setRepresentante(new Representante(idRepresentante)); // guarda o id do representante, dentro do cliente
		
		enderecoDao.cadastrar(endereco); // persiste o endereco
		
		clienteDao.cadastrar(cliente); // persiste o cliente
	}

}
