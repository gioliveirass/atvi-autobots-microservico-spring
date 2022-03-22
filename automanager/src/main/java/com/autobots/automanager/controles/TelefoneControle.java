package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.ClienteAtualizador;
import com.autobots.automanager.modelo.ClienteSelecionador;
import com.autobots.automanager.modelo.TelefoneAtualizador;
import com.autobots.automanager.modelo.TelefoneSelecionador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

@RestController
@RequestMapping("/telefone")
public class TelefoneControle {
	@Autowired
	private TelefoneRepositorio repositorioTelefone;
	@Autowired
	private TelefoneSelecionador selecionadorTelefone;
	@Autowired
	private ClienteRepositorio repositorioCliente;
	@Autowired
	private ClienteSelecionador selecionadorCliente;
	
	@GetMapping("/telefone/{id}")
	public Telefone obterTelefone(@PathVariable long id) {
		List<Telefone> telefones = repositorioTelefone.findAll();
		return selecionadorTelefone.selecionar(telefones, id);
	}
	
	@GetMapping("/telefones")
	public List<Telefone> obterTelefone() {
		List<Telefone> telefones = repositorioTelefone.findAll();
		return telefones;
	}
	
	@PostMapping("/cadastro")
	public void cadastrarTelefone(@RequestBody Cliente cliente) {
		List<Cliente> clientes = repositorioCliente.findAll();
		Cliente selecionado = selecionadorCliente.selecionar(clientes, cliente.getId());
		selecionado.getTelefones().addAll(cliente.getTelefones());
		repositorioCliente.save(selecionado);
	}
	
	@PutMapping("/atualizar")
	public void atualizarTelefone(@RequestBody Cliente atualizacao) {
		Cliente cliente = repositorioCliente.getById(atualizacao.getId());
		TelefoneAtualizador atualizador = new TelefoneAtualizador();
		atualizador.atualizar(cliente.getTelefones(), atualizacao.getTelefones());
		repositorioCliente.save(cliente);
	}

	@DeleteMapping("/excluir/{idTelefone}")
	public void excluirTelefone(@RequestBody Cliente cliente, @PathVariable long idTelefone) {
		List<Cliente> clientes = repositorioCliente.findAll();
		Cliente clienteSelecionado = selecionadorCliente.selecionar(clientes, cliente.getId());
		List<Telefone> telefones = clienteSelecionado.getTelefones();
		Telefone telefoneSelecionado = selecionadorTelefone.selecionar(telefones, idTelefone);
		telefones.remove(telefoneSelecionado);
		repositorioCliente.save(clienteSelecionado);
	}
}
