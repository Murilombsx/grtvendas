package br.com.grtvendas.gerenciador;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.grtvendas.daos.EnderecoDao;
import br.com.grtvendas.daos.RepresentanteDao;
import br.com.grtvendas.dtos.entrada.RepresentanteEditavelDTO;
import br.com.grtvendas.models.Cliente;
import br.com.grtvendas.models.Endereco;
import br.com.grtvendas.models.Pedido;
import br.com.grtvendas.models.Representante;

public class RepresentanteGerenciador {

	@Inject
	private RepresentanteDao representanteDao;

	@Inject
	private EnderecoDao enderecoDao;

	public List<Representante> todosRepresentantes() {
		return representanteDao.listar();
	}

	public Representante buscaPorId(Integer id) {
		return representanteDao.buscaPorId(id);
	}

	@Transactional
	public void remove(Representante representante) {
		Set<Pedido> pedidos = representante.getPedidos();
		Set<Cliente> clientes = representante.getClientes();
		if (!pedidos.isEmpty() || !clientes.isEmpty()) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
					.entity("Não é possível remover um representante com um cliente ou pedido associado").build());
		} else {
			representanteDao.remove(representante);
		}

	}

	@Transactional
	public Representante cadastrar(Representante representante) {

		Endereco endereco = representante.getEndereco();

		if (endereco.getRua() == null || endereco.getRua().trim().equals("") || endereco.getNumero() == null
				|| endereco.getNumero().trim().equals("") || endereco.getBairro() == null
				|| endereco.getBairro().trim().equals("") || endereco.getCidade() == null
				|| endereco.getCidade().trim().equals("") || endereco.getEstado() == null
				|| endereco.getEstado().trim().equals("") || endereco.getCep() == null
				|| endereco.getCep().trim().equals("")) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
					.entity("Campos obrigatórios de endereço não foram preenchidos").build());
		} else {
			enderecoDao.cadastrar(endereco);
		}

		if (representante.getCnpj() == null || representante.getCnpj().trim().equals("")
				|| representante.getCpf() == null || representante.getCpf().trim().equals("")
				|| representante.getEmail() == null || representante.getEmail().trim().equals("")
				|| representante.getRazaoSocial() == null || representante.getRazaoSocial().trim().equals("")
				|| representante.getTelefone() == null || representante.getTelefone().trim().equals("")
				|| representante.getRg() == null || representante.getRg().trim().equals("")
				|| representante.getDataEntrada() == null || representante.getDataEntrada().toString().trim().equals("")
				|| representante.getNome() == null || representante.getNome().trim().equals("")) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
					.entity("Campos obrigatórios não foram preenchidos").build());
		} else {
			representanteDao.cadastrar(representante);
		}
		return representante;
	}

	@Transactional
	public void atualiza(Representante representante, RepresentanteEditavelDTO representanteEditavelDTO) {
		if ((representante.getEmail() != representanteEditavelDTO.getEmail())
				&& (representanteEditavelDTO.getEmail() != null)
				&& (!representanteEditavelDTO.getEmail().trim().equals(""))) {
			representante.setEmail(representanteEditavelDTO.getEmail());
		}

		if ((representante.getTelefone() != representanteEditavelDTO.getTelefone())
				&& (representanteEditavelDTO.getTelefone() != null)
				&& (!representanteEditavelDTO.getTelefone().trim().equals(""))) {
			representante.setTelefone(representanteEditavelDTO.getTelefone());
		}

		if ((representante.getEndereco().getRua() != representanteEditavelDTO.getEndereco().getRua())
				&& (representanteEditavelDTO.getEndereco().getRua() != null)
				&& (!representanteEditavelDTO.getEndereco().getRua().trim().equals(""))) {
			representante.getEndereco().setRua(representanteEditavelDTO.getEndereco().getRua());
		}

		if ((representante.getEndereco().getNumero() != representanteEditavelDTO.getEndereco().getNumero())
				&& (representanteEditavelDTO.getEndereco().getNumero() != null)
				&& (!representanteEditavelDTO.getEndereco().getNumero().trim().equals(""))) {
			representante.getEndereco().setNumero(representanteEditavelDTO.getEndereco().getNumero());
		}

		if ((representante.getEndereco().getComplemento() != representanteEditavelDTO.getEndereco().getComplemento())
				&& (representanteEditavelDTO.getEndereco().getComplemento() != null)
				&& (!representanteEditavelDTO.getEndereco().getComplemento().trim().equals(""))) {
			representante.getEndereco().setComplemento(representanteEditavelDTO.getEndereco().getComplemento());
		}

		if ((representante.getEndereco().getBairro() != representanteEditavelDTO.getEndereco().getBairro())
				&& (representanteEditavelDTO.getEndereco().getBairro() != null)
				&& (!representanteEditavelDTO.getEndereco().getBairro().trim().equals(""))) {
			representante.getEndereco().setBairro(representanteEditavelDTO.getEndereco().getBairro());
		}

		if ((representante.getEndereco().getCidade() != representanteEditavelDTO.getEndereco().getCidade())
				&& (representanteEditavelDTO.getEndereco().getCidade() != null)
				&& (!representanteEditavelDTO.getEndereco().getCidade().trim().equals(""))) {
			representante.getEndereco().setCidade(representanteEditavelDTO.getEndereco().getCidade());
		}

		if ((representante.getEndereco().getEstado() != representanteEditavelDTO.getEndereco().getEstado())
				&& (representanteEditavelDTO.getEndereco().getEstado() != null)
				&& (!representanteEditavelDTO.getEndereco().getEstado().trim().equals(""))) {
			representante.getEndereco().setEstado(representanteEditavelDTO.getEndereco().getEstado());
		}

		if ((representante.getEndereco().getCep() != representanteEditavelDTO.getEndereco().getCep())
				&& (representanteEditavelDTO.getEndereco().getCep() != null)
				&& (!representanteEditavelDTO.getEndereco().getCep().trim().equals(""))) {
			representante.getEndereco().setCep(representanteEditavelDTO.getEndereco().getCep());
		}

		representanteDao.atualiza(representante);
	}

}
