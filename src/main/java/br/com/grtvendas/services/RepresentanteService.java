package br.com.grtvendas.services;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.grtvendas.gerenciador.RepresentanteGerenciador;
import br.com.grtvendas.models.Representante;

@Path("/representante")
@RequestScoped
public class RepresentanteService {

	/*@Inject // aparentemente o problema está nesta injeção
	private RepresentanteGerenciador representanteGerenciador;
	
	@GET
	@Path("/descricao/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Representante visualiza(@PathParam("id") Integer id) {
		System.out.println("Testando");
		Representante r1 = representanteGerenciador.buscaPorId(id);
		System.out.println(r1);
		return r1;
	}*/
	
	@GET
	@Path("/teste/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Representante teste(@PathParam("id") Integer id) {
		Representante r1 = new Representante();
		r1.setNome("Jose");
		r1.setRg("65626");
		return r1;
	}


}
