package br.com.grtvendas.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.grtvendas.dtos.resposta.RepresentanteDTOResposta;
import br.com.grtvendas.dtos.resposta.RepresentanteResumoDTOResposta;
import br.com.grtvendas.gerenciador.RepresentanteGerenciador;
import br.com.grtvendas.models.Representante;

@Path("/representantes")
@RequestScoped
public class RepresentanteService {

	@Inject
	private RepresentanteGerenciador representanteGerenciador;

	// Funcionando ok
	// Lista todos representantes de forma resumida
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RepresentanteResumoDTOResposta> listar() {
		List<Representante> representantesOriginalAuxiliar = representanteGerenciador.todosRepresentantes();
		List<RepresentanteResumoDTOResposta> representantes = new ArrayList<>();
		for (Representante representanteOriginalAuxiliar : representantesOriginalAuxiliar) {
			RepresentanteResumoDTOResposta representante = new RepresentanteResumoDTOResposta()
					.transformaEmDTO(representanteOriginalAuxiliar);
			representantes.add(representante);
		}

		return representantes;
	}
	
	// Funcionando ok
	// Detalha um representante, com todas informações sobre ele, incluso endereço,
	// clientes e pedidos
	@GET
	@Path("/detalhe/{idRepresentante}")
	@Produces(MediaType.APPLICATION_JSON)
	public RepresentanteDTOResposta detalhe(@PathParam("idRepresentante") Integer idRepresentante) {
		Representante representanteOriginalAuxiliar = representanteGerenciador.buscaPorId(idRepresentante);
		RepresentanteDTOResposta representante = new RepresentanteDTOResposta().transformaEmDTO(representanteOriginalAuxiliar);

		return representante;
	}

}
