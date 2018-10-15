package br.com.grtvendas.dtos.resposta;

import br.com.grtvendas.models.Endereco;
import br.com.grtvendas.models.Representante;

public class RepresentanteIdEstDTOResposta {

	private Integer id;
	private EnderecoResumoEstadoDTOResposta endereco;

	public RepresentanteIdEstDTOResposta() {
	}

	public RepresentanteIdEstDTOResposta(Integer id, EnderecoResumoEstadoDTOResposta endereco) {
		this.id = id;
		this.endereco = endereco;
	}

	public RepresentanteIdEstDTOResposta transformaEmDTO(Representante representante) {
		Endereco enderecoOriginalAuxiliar = representante.getEndereco();
		EnderecoResumoEstadoDTOResposta endereco = new EnderecoResumoEstadoDTOResposta()
				.transformaEmDTO(enderecoOriginalAuxiliar);

		return new RepresentanteIdEstDTOResposta(representante.getId(), endereco);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EnderecoResumoEstadoDTOResposta getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoResumoEstadoDTOResposta endereco) {
		this.endereco = endereco;
	}

}
