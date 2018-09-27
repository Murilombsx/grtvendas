package br.com.grtvendas.gerenciador;

import java.util.List;

import javax.inject.Inject;

import br.com.grtvendas.daos.RepresentanteDao;
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
	
}
