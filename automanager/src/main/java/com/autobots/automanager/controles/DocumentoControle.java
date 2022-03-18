package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.ClienteAtualizador;
import com.autobots.automanager.modelo.ClienteSelecionador;
import com.autobots.automanager.modelo.DocumentoAtualizador;
import com.autobots.automanager.modelo.DocumentoSelecionador;
import com.autobots.automanager.modelo.TelefoneAtualizador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

@RestController
@RequestMapping("/documento")
public class DocumentoControle {
	@Autowired
	private DocumentoRepositorio repositorioDocumento;
	@Autowired
	private DocumentoSelecionador selecionadorDocumento;
	@Autowired
	private ClienteRepositorio repositorioCliente;
	@Autowired
	private ClienteSelecionador selecionadorCliente;
	
	@GetMapping("/documento/{id}")
	public Documento obterDocumento(@PathVariable long id) {
		List<Documento> documentos = repositorioDocumento.findAll();
		return selecionadorDocumento.selecionar(documentos, id);
	}
	
	@GetMapping("/documentos")
	public List<Documento> obterDocumento() {
		List<Documento> documentos = repositorioDocumento.findAll();
		return documentos;
	}
	
	@PostMapping("/cadastro")
	public void cadastrarDocumento(@RequestBody Cliente cliente) {
		List<Cliente> clientes = repositorioCliente.findAll();
		Cliente selecionado = selecionadorCliente.selecionar(clientes, cliente.getId());
		selecionado.getDocumentos().addAll(cliente.getDocumentos());
		repositorioCliente.save(selecionado);
	}
	
	@PutMapping("/atualizar")
	public void atualizarDocumento(@RequestBody Cliente atualizacao) {
		Cliente cliente = repositorioCliente.getById(atualizacao.getId());
		DocumentoAtualizador atualizador = new DocumentoAtualizador();
		atualizador.atualizar(cliente.getDocumentos(), atualizacao.getDocumentos());
		repositorioCliente.save(cliente);
	}
	
}
