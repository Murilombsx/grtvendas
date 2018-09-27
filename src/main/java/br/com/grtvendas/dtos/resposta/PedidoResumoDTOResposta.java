package br.com.grtvendas.dtos.resposta;

import br.com.grtvendas.models.Pedido;

/*
	Classe de visualização de Pedido resumida, que mostra apenas:
		- id e numero do pedido
*/

public class PedidoResumoDTOResposta {

	private Integer id;
	private int numero;

	public PedidoResumoDTOResposta() {}

	public PedidoResumoDTOResposta(Integer id, int numero) {
		this.id = id;
		this.numero = numero;
	}

	public PedidoResumoDTOResposta transformaEmDTO(Pedido pedido) {
		return new PedidoResumoDTOResposta(pedido.getId(), pedido.getNumero());
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

}
