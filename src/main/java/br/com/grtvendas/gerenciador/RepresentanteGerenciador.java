package br.com.grtvendas.gerenciador;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.grtvendas.daos.RepresentanteDao;

public class RepresentanteGerenciador implements Serializable {
	
	@Inject
	private RepresentanteDao representanteDao;
	
}
