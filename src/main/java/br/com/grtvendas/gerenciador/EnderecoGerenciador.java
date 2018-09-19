package br.com.grtvendas.gerenciador;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.grtvendas.daos.EnderecoDao;
import br.com.grtvendas.models.Endereco;

public class EnderecoGerenciador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EnderecoDao enderecoDao;
	
	public Endereco buscaPorId(int id) {
		return enderecoDao.buscaPorId(id);
	}
	
	public List<Endereco> todosEnderecos() {
		return enderecoDao.listar();
	}

	public Endereco cadastrar(Endereco endereco) {
		enderecoDao.cadastrar(endereco);
		
		return endereco;
	}

}
