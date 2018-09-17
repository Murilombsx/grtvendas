package br.com.grtvendas.gerenciador;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.grtvendas.daos.RepresentanteDao;
import br.com.grtvendas.models.Representante;

public class RepresentanteGerenciador implements Serializable {
	
	@Inject
	private RepresentanteDao representanteDao;
	
	@Transactional
	public Representante buscaPorId(int id) {
		return representanteDao.buscaPorId(id);
	}

}
