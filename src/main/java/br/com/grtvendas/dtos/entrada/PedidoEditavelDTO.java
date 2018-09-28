package br.com.grtvendas.dtos.entrada;

import java.math.BigDecimal;

import br.com.grtvendas.models.Pedido;

/*
	Classe de inserção dos dados de um pedido, que filtra apenas os campos que deseja receber:
		- Alguns campos do pedido
*/

public class PedidoEditavelDTO {

	private Integer id;
	private int qtdePecas;
	private BigDecimal valorTotal;
	private String observacao;

	public Pedido transformaParaObjeto() {
		return new Pedido(id, qtdePecas, valorTotal, observacao);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
