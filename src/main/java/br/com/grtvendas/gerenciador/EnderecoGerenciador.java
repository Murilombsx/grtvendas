package br.com.grtvendas.gerenciador;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.grtvendas.daos.EnderecoDao;
import br.com.grtvendas.models.Endereco;

public class EnderecoGerenciador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EnderecoDao enderecoDao;
	
	@Transactional
	public Endereco buscaPorId(int id) {
		return enderecoDao.buscaPorId(id);
	}
	
	@Transactional
	public List<Endereco> todosEnderecos() {
		return enderecoDao.listar();
	}

}
