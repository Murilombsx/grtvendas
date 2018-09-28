package br.com.grtvendas.dtos.resposta;

import java.math.BigDecimal;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Pedido;
import br.com.grtvendas.models.Representante;

/*
	Classe de visualização de Pedido completa, que mostra:
		- Todas informações do pedido
		- id, nome fantasia e cnpj do cliente
		- id, nome e estado do representante
*/

public class PedidoDTOResposta {

	private Integer id;
	private int numero;
	private int qtdePecas;
	private BigDecimal valorTotal;
	private String observacao;
	private ClienteResumoComEnderecoDTOResposta cliente;
	private RepresentanteResumoDTOResposta representante;

	public PedidoDTOResposta() {
	}

	public PedidoDTOResposta(Integer id, int numero, int qtdePecas, BigDecimal valorTotal, String observacao,
			ClienteResumoComEnderecoDTOResposta cliente, RepresentanteResumoDTOResposta representante) {
		this.id = id;
		this.numero = numero;
		this.qtdePecas = qtdePecas;
		this.valorTotal = valorTotal;
		this.observacao = observacao;
		this.cliente = cliente;
		this.representante = representante;
	}

	public PedidoDTOResposta transformaEmDTO(Pedido pedido) {
		Cliente clienteOriginalAuxiliar = pedido.getCliente();
		ClienteResumoComEnderecoDTOResposta cliente = new ClienteResumoComEnderecoDTOResposta()
				.transformaEmDTO(clienteOriginalAuxiliar);

		Representante representanteOriginalAuxiliar = pedido.getRepresentante();
		RepresentanteResumoDTOResposta representante = new RepresentanteResumoDTOResposta()
				.transformaEmDTO(representanteOriginalAuxiliar);

		return new PedidoDTOResposta(pedido.getId(), pedido.getNumero(), pedido.getQtdePecas(), pedido.getValorTotal(),
				pedido.getObservacao(), cliente, representante);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getQtdePecas() {
		return qtdePecas;
	}

	public void setQtdePecas(int qtdePecas) {
		this.qtdePecas = qtdePecas;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ClienteResumoComEnderecoDTOResposta getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResumoComEnderecoDTOResposta cliente) {
		this.cliente = cliente;
	}

	public RepresentanteResumoDTOResposta getRepresentante() {
		return representante;
	}

	public void setRepresentante(RepresentanteResumoDTOResposta representante) {
		this.representante = representante;
	}

}
