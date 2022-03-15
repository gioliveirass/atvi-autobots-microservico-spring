package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.ClienteSelecionador;
import com.autobots.automanager.modelo.TelefoneSelecionador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

@RestController
@RequestMapping("/telefone")
public class TelefoneControle {
	@Autowired
	private TelefoneRepositorio repositorio;
	@Autowired
	private TelefoneSelecionador selecionador;
	@Autowired
	private ClienteRepositorio repositorioCliente;
	@Autowired
	private ClienteSelecionador selecionadorCliente;
	
	@GetMapping("/telefone/{id}")
	public Telefone obterTelefone(@PathVariable long id) {
		List<Telefone> telefones = repositorio.findAll();
		return selecionador.selecionar(telefones, id);
	}
	
	@GetMapping("/telefones")
	public List<Telefone> obterTelefone() {
		List<Telefone> telefones = repositorio.findAll();
		return telefones;
	}
	
	@PostMapping("/cadastro")
	public void cadastrarTelefone(@RequestBody Cliente cliente) {
		List<Cliente> clientes = repositorioCliente.findAll();
		Cliente selecionado = selecionadorCliente.selecionar(clientes, cliente.getId());
		selecionado.getTelefones().addAll(cliente.getTelefones());
		
		// selecionado.setTelefones(cliente.getTelefones());
		// selecionado.getTelefones().add(cliente.getTelefones());
		
		repositorioCliente.save(selecionado);
	}
}
