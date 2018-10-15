package br.com.grtvendas.models;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Representante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private Calendar dataEntrada;
	private String razaoSocial;
	private String cnpj;
	private String telefone;

	@JoinColumn(unique = true)
	@OneToOne
	private Endereco endereco;

	@OneToMany(mappedBy = "representante")
	private Set<Pedido> pedidos = new HashSet<>();

	@OneToMany(mappedBy = "representante")
	private Set<Cliente> clientes = new HashSet<>();

	public Representante() {
	}

	public Representante(Integer id) {
		this.id = id;
	}

	public Representante(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Representante(String nome, String razaoSocial, String cnpj, String cpf, String rg, String email,
			String telefone, Endereco endereco) {
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Representante(Integer id, String email, String telefone, Endereco endereco) {
		this.id = id;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Representante [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", email=" + email
				+ ", dataEntrada=" + dataEntrada + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", endereco="
				+ endereco + ", pedidos=" + pedidos + ", clientes=" + clientes + "]";
	}

}
