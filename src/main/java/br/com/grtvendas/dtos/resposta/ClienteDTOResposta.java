package br.com.grtvendas.dtos.resposta;

import java.util.ArrayList;
import java.util.List;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Endereco;
import br.com.grtvendas.models.Pedido;
import br.com.grtvendas.models.Representante;

/*
	Classe de visualização de Cliente completa, que mostra:
		- Todas informações do cliente, incluso endereço
		- id e nome do representante
		- id e numero de cada pedido deste cliente
*/

public class ClienteDTOResposta {

	private Integer id;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	private String pessoaContato;
	private String email;
	private String telefone;
	private Endereco endereco;
	private RepresentanteResumoDTOResposta representante;
	private List<PedidoResumoRefinadoDTOResposta> pedidos = new ArrayList<>();

	public ClienteDTOResposta() {
	}

	public ClienteDTOResposta(Integer id, String nomeFantasia, String razaoSocial, String cnpj,
			String inscricaoEstadual, String pessoaContato, String email, String telefone, Endereco endereco,
			RepresentanteResumoDTOResposta representante, List<PedidoResumoRefinadoDTOResposta> pedidos) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.pessoaContato = pessoaContato;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.representante = representante;
		this.pedidos = pedidos;
	}

	public ClienteDTOResposta transformaEmDTO(Cliente cliente) {
		Representante representanteOriginalAuxiliar = cliente.getRepresentante();
		RepresentanteResumoDTOResposta representante = new RepresentanteResumoDTOResposta()
				.transformaEmDTO(representanteOriginalAuxiliar);

		List<PedidoResumoRefinadoDTOResposta> pedidos = new ArrayList<>();
		List<Pedido> pedidosOriginalAuxiliar = cliente.getPedidos();

		for (Pedido pedidoOriginalAuxiliar : pedidosOriginalAuxiliar) {
			PedidoResumoRefinadoDTOResposta pedido = new PedidoResumoRefinadoDTOResposta().transformaEmDTO(pedidoOriginalAuxiliar);
			pedidos.add(pedido);
		}

		return new ClienteDTOResposta(cliente.getId(), cliente.getNomeFantasia(), cliente.getRazaoSocial(),
				cliente.getCnpj(), cliente.getInscricaoEstadual(), cliente.getPessoaContato(), cliente.getEmail(),
				cliente.getTelefone(), cliente.getEndereco(), representante, pedidos);
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

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getPessoaContato() {
		return pessoaContato;
	}

	public void setPessoaContato(String pessoaContato) {
		this.pessoaContato = pessoaContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public RepresentanteResumoDTOResposta getRepresentante() {
		return representante;
	}

	public void setRepresentante(RepresentanteResumoDTOResposta representante) {
		this.representante = representante;
	}

	public List<PedidoResumoRefinadoDTOResposta> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoResumoRefinadoDTOResposta> pedidos) {
		this.pedidos = pedidos;
	}

}
