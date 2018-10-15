package br.com.grtvendas.dtos.entrada;

import java.math.BigDecimal;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Pedido;
import br.com.grtvendas.models.Representante;

/*
	Classe de inserção dos dados de um pedido, que filtra apenas os campos que deseja receber:
		- Todas informações do pedido (menos id)
		- id e nome fantasia do cliente
		- id e nome do representante
*/

public class PedidoDTO {

	private int qtdePecas;
	private BigDecimal valorTotal;
	private String observacao;
	private ClienteIdDTO cliente;
	private RepresentanteIdDTO representante;

	public Pedido transformaParaObjeto() {
		Cliente cliente = this.cliente.transformaParaObjeto();
		Representante representante = this.representante.transformaParaObjeto();
		return new Pedido(qtdePecas, valorTotal, observacao, cliente, representante);
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

	public ClienteIdDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteIdDTO cliente) {
		this.cliente = cliente;
	}

	public RepresentanteIdDTO getRepresentante() {
		return representante;
	}

	public void setRepresentante(RepresentanteIdDTO representante) {
		this.representante = representante;
	}

}
