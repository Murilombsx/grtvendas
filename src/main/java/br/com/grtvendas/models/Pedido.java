package br.com.grtvendas.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private int numero;
	private int qtdePecas;
	private BigDecimal valorTotal;
	private String observacao;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Representante representante;

	public Pedido() {
	}

	public Pedido(int numPedido, int qtdePecas) {
		this.numero = numPedido;
		this.qtdePecas = qtdePecas;
	}

	public Pedido(int qtdePecas, BigDecimal valorTotal, String observacao, Cliente cliente,
			Representante representante) {
		this.qtdePecas = qtdePecas;
		this.valorTotal = valorTotal;
		this.observacao = observacao;
		this.cliente = cliente;
		this.representante = representante;
	}

	public Pedido(Integer id, int qtdePecas, BigDecimal valorTotal, String observacao) {
		this.id = id;
		this.qtdePecas = qtdePecas;
		this.valorTotal = valorTotal;
		this.observacao = observacao;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", numero=" + numero + ", qtdePecas=" + qtdePecas + ", valorTotal=" + valorTotal
				+ ", observacao=" + observacao + ", cliente=" + cliente + ", representante=" + representante + "]";
	}

}