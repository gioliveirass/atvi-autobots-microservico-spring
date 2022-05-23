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
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.services.ClienteDocumento;
import com.autobots.automanager.modelo.AdicionadorLinkDocumento;
import com.autobots.automanager.modelo.ClienteAtualizador;
import com.autobots.automanager.modelo.ClienteSelecionador;
import com.autobots.automanager.modelo.DocumentoAtualizador;
import com.autobots.automanager.modelo.DocumentoSelecionador;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

@RestController
public class DocumentoControle {
	@Autowired
	private DocumentoRepositorio repositorioDocumento;
	@Autowired
	private DocumentoSelecionador selecionadorDocumento;
	@Autowired
	private ClienteRepositorio repositorioCliente;
	@Autowired
	private ClienteSelecionador selecionadorCliente;
	@Autowired
	private AdicionadorLinkDocumento adicionadorLink;
	
	@GetMapping("/documento/{id}")
	public ResponseEntity<Documento> obterDocumento(@PathVariable long id) {
		List<Documento> documentos = repositorioDocumento.findAll();
		Documento documento = selecionadorDocumento.selecionar(documentos, id);
		
		if(documento == null) {
			ResponseEntity<Documento> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(documento);
			ResponseEntity<Documento> resposta = new ResponseEntity<Documento>(documento, HttpStatus.FOUND);
			return resposta;
		}
	}
	
	@GetMapping("/documentos")
	public ResponseEntity<List<Documento>> obterDocumento() {
		List<Documento> documentos = repositorioDocumento.findAll();

		if(documentos.isEmpty()) {
			ResponseEntity<List<Documento>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(documentos);
			ResponseEntity<List<Documento>> resposta = new ResponseEntity<>(documentos, HttpStatus.FOUND);
			return resposta;
		}
	}
	
	@PostMapping("/documento/cadastro")
	public ResponseEntity<?> cadastrarDocumento(@RequestBody Cliente cliente) {
		HttpStatus status = HttpStatus.CONFLICT;
		
		List<Cliente> clientes = repositorioCliente.findAll();
		Cliente selecionado = selecionadorCliente.selecionar(clientes, cliente.getId());
		
		if (selecionado != null) {
			selecionado.getDocumentos().addAll(cliente.getDocumentos());
			repositorioCliente.save(selecionado);
			status = HttpStatus.CREATED;
		}
		return new ResponseEntity<>(status);
	}
	
	@PutMapping("/documento/atualizar")
	public ResponseEntity<?> atualizarDocumento(@RequestBody Cliente atualizacao) {
		HttpStatus status = HttpStatus.CONFLICT;
		Cliente cliente = repositorioCliente.getById(atualizacao.getId());
		DocumentoAtualizador atualizador = new DocumentoAtualizador();
		
		if(cliente != null) {
			atualizador.atualizar(cliente.getDocumentos(), atualizacao.getDocumentos());
			repositorioCliente.save(cliente);
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		
		return new ResponseEntity<>(status);
	}
	
	@DeleteMapping("/documento/excluir")
	public ResponseEntity<?> excluirDocumento(@RequestBody ClienteDocumento listId) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		List<Cliente> clientes = repositorioCliente.findAll();
		Cliente clienteSelecionado = selecionadorCliente.selecionar(clientes, listId.getId());
		List<Documento> documentos = clienteSelecionado.getDocumentos();
		Documento documentoSelecionado = selecionadorDocumento.selecionar(documentos, listId.getIdDocumento());
		
		if (documentoSelecionado != null) {
			documentos.remove(documentoSelecionado);
			repositorioCliente.save(clienteSelecionado);
			status = HttpStatus.OK;
		}
		
		return new ResponseEntity<>(status);
	}
	
}
