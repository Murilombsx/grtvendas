package br.com.grtvendas.dtos;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Representante;

/*
	Classe de visualização de Cliente resumida, que mostra:
		- id, nome fantasia, razão social e cnpj
		- id e nome do representante
*/

public class ClienteResumoDTOResposta {

	private Integer id;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private RepresentanteResumoDTOResposta representante;

	public ClienteResumoDTOResposta() {
	}

	public ClienteResumoDTOResposta(Integer id, String nomeFantasia, String razaoSocial, String cnpj,
			RepresentanteResumoDTOResposta representante) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.representante = representante;
	}

	public ClienteResumoDTOResposta transformaEmDTO(Cliente cliente) {
		Representante representanteOriginalAuxiliar = cliente.getRepresentante();
		RepresentanteResumoDTOResposta representante = new RepresentanteResumoDTOResposta()
				.transformaEmDTO(representanteOriginalAuxiliar);

		return new ClienteResumoDTOResposta(cliente.getId(), cliente.getNomeFantasia(), cliente.getRazaoSocial(),
				cliente.getCnpj(), representante);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public RepresentanteResumoDTOResposta getRepresentante() {
		return representante;
	}

	public void setRepresentante(RepresentanteResumoDTOResposta representante) {
		this.representante = representante;
	}

}
