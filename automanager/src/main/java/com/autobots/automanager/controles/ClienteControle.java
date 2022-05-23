package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.modelo.AdicionadorLinkCliente;
import com.autobots.automanager.modelo.ClienteAtualizador;
import com.autobots.automanager.modelo.ClienteSelecionador;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@RestController
public class ClienteControle {
	@Autowired
	private ClienteRepositorio repositorio;
	@Autowired
	private ClienteSelecionador selecionador;
	@Autowired
	private AdicionadorLinkCliente adicionadorLink;

	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> obterCliente(@PathVariable long id) {
		List<Cliente> clientes = repositorio.findAll();
		Cliente cliente = selecionador.selecionar(clientes, id);
		
		if(cliente == null) {
			ResponseEntity<Cliente> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(cliente);
			ResponseEntity<Cliente> resposta = new ResponseEntity<Cliente>(cliente, HttpStatus.FOUND);
			return resposta;
		}
	}

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> obterClientes() {
		List<Cliente> clientes = repositorio.findAll();
		
		if(clientes.isEmpty()) {
			ResponseEntity<List<Cliente>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(clientes);
			ResponseEntity<List<Cliente>> resposta = new ResponseEntity<>(clientes, HttpStatus.FOUND);
			return resposta;
		}
	}

	@PostMapping("/cliente/cadastro")
	public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente clienteNovo) {
		HttpStatus status = HttpStatus.CONFLICT;
		if (clienteNovo.getId() == null) {
			repositorio.save(clienteNovo);
			status = HttpStatus.CREATED;
		}
		return new ResponseEntity<>(status);
	}

	@PutMapping("/cliente/atualizar")
	public ResponseEntity<?> atualizarCliente(@RequestBody Cliente clienteAtualizar) {
		HttpStatus status = HttpStatus.CONFLICT;
		Cliente cliente = repositorio.getById(clienteAtualizar.getId());
		
		if(cliente != null) {
			ClienteAtualizador atualizador = new ClienteAtualizador();
			atualizador.atualizar(cliente, clienteAtualizar);
			repositorio.save(cliente);
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		
		return new ResponseEntity<>(status);
	}

	@DeleteMapping("/cliente/excluir")
	public ResponseEntity<?> excluirCliente(@RequestBody Cliente clienteExcluir) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Cliente cliente = repositorio.getById(clienteExcluir.getId());
		
		if (cliente != null) {
			repositorio.delete(cliente);
			status = HttpStatus.OK;
		}
		
		return new ResponseEntity<>(status);
	}
}
