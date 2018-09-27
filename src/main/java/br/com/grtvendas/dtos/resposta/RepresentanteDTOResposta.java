package br.com.grtvendas.dtos.resposta;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Endereco;
import br.com.grtvendas.models.Pedido;
import br.com.grtvendas.models.Representante;

/*
	Classe de visualização de Representante completa, que mostra:
		- Todas informações do representante, incluso endereço
		- id e nome de cada cliente deste representante
		- id e numero de cada pedido deste representante
*/

public class RepresentanteDTOResposta {

	private Integer id;
	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private Calendar dataEntrada;
	private String razaoSocial;
	private String cnpj;
	private Endereco endereco;
	private Set<ClienteResumoRefinadoDTOResposta> clientes = new HashSet<>();
	private Set<PedidoResumoDTOResposta> pedidos = new HashSet<>();

	public RepresentanteDTOResposta() {
	}

	public RepresentanteDTOResposta(Integer id, String nome, String cpf, String rg, String email, Calendar dataEntrada,
			String razaoSocial, String cnpj, Endereco endereco, Set<ClienteResumoRefinadoDTOResposta> clientes,
			Set<PedidoResumoDTOResposta> pedidos) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.dataEntrada = dataEntrada;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.clientes = clientes;
		this.pedidos = pedidos;
	}

	public RepresentanteDTOResposta transformaEmDTO(Representante representante) {
		Set<ClienteResumoRefinadoDTOResposta> clientes = new HashSet<>();
		Set<Cliente> clientesOriginalAuxiliar = representante.getClientes();
		for (Cliente clienteOriginalAuxiliar : clientesOriginalAuxiliar) {
			ClienteResumoRefinadoDTOResposta cliente = new ClienteResumoRefinadoDTOResposta()
					.transformaEmDTO(clienteOriginalAuxiliar);
			clientes.add(cliente);
		}

		Set<PedidoResumoDTOResposta> pedidos = new HashSet<>();
		Set<Pedido> pedidosOriginalAuxiliar = representante.getPedidos();
		for (Pedido pedidoOriginalAuxiliar : pedidosOriginalAuxiliar) {
			PedidoResumoDTOResposta pedido = new PedidoResumoDTOResposta().transformaEmDTO(pedidoOriginalAuxiliar);
			pedidos.add(pedido);
		}

		return new RepresentanteDTOResposta(representante.getId(), representante.getNome(), representante.getCpf(),
				representante.getRg(), representante.getEmail(), representante.getDataEntrada(),
				representante.getRazaoSocial(), representante.getCnpj(), representante.getEndereco(), clientes,
				pedidos);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<ClienteResumoRefinadoDTOResposta> getClientes() {
		return clientes;
	}

	public void setClientes(Set<ClienteResumoRefinadoDTOResposta> clientes) {
		this.clientes = clientes;
	}

	public Set<PedidoResumoDTOResposta> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<PedidoResumoDTOResposta> pedidos) {
		this.pedidos = pedidos;
	}

}
