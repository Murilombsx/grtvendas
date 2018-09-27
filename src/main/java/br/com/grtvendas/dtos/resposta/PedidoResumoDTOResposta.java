package br.com.grtvendas.dtos.resposta;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Pedido;
import br.com.grtvendas.models.Representante;

/*
	Classe de visualização de Pedido resumida, que mostra:
		- id e numero do pedido
		- id, nome fantasia e cnpj do cliente
		- id e nome do representante
*/

public class PedidoResumoDTOResposta {

	private Integer id;
	private int numero;
	private ClienteResumoRefinadoDTOResposta cliente;
	private RepresentanteResumoRefinadoDTOResposta representante;

	public PedidoResumoDTOResposta() {
	}

	public PedidoResumoDTOResposta(Integer id, int numero, ClienteResumoRefinadoDTOResposta cliente,
			RepresentanteResumoRefinadoDTOResposta representante) {
		this.id = id;
		this.numero = numero;
		this.cliente = cliente;
		this.representante = representante;
	}

	public PedidoResumoDTOResposta transformaEmDTO(Pedido pedido) {
		Cliente clienteOriginalAuxiliar = pedido.getCliente();
		ClienteResumoRefinadoDTOResposta cliente = new ClienteResumoRefinadoDTOResposta()
				.transformaEmDTO(clienteOriginalAuxiliar);

		Representante representanteOriginalAuxiliar = pedido.getRepresentante();
		RepresentanteResumoRefinadoDTOResposta representante = new RepresentanteResumoRefinadoDTOResposta()
				.transformaEmDTO(representanteOriginalAuxiliar);

		return new PedidoResumoDTOResposta(pedido.getId(), pedido.getNumero(), cliente, representante);
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

	public ClienteResumoRefinadoDTOResposta getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResumoRefinadoDTOResposta cliente) {
		this.cliente = cliente;
	}

	public RepresentanteResumoRefinadoDTOResposta getRepresentante() {
		return representante;
	}

	public void setRepresentante(RepresentanteResumoRefinadoDTOResposta representante) {
		this.representante = representante;
	}

}
