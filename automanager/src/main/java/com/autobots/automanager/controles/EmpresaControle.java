package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Empresa;
import com.autobots.automanager.modelo.AdicionarLinkEmpresa;
import com.autobots.automanager.modelo.EmpresaSelecionador;
import com.autobots.automanager.repositorios.EmpresaRepositorio;

@RestController
public class EmpresaControle {
	@Autowired
	private EmpresaRepositorio repositorio;
	@Autowired
	private EmpresaSelecionador selecionador;
	@Autowired
	private AdicionarLinkEmpresa adicionadorLink;

	@GetMapping("/empresa/{id}")
	public ResponseEntity<Empresa> obterEmpresa(@PathVariable long id) {
		List<Empresa> empresas = repositorio.findAll();
		Empresa empresa = selecionador.selecionar(empresas, id);
		
		if(empresa == null) {
			ResponseEntity<Empresa> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(empresa);
			ResponseEntity<Empresa> resposta = new ResponseEntity<Empresa>(empresa, HttpStatus.FOUND);
			return resposta;
		}
	}
	
	@GetMapping("/empresas")
	public ResponseEntity<List<Empresa>> obterEmpresas() {
		List<Empresa> empresas = repositorio.findAll();
		
		if(empresas.isEmpty()) {
			ResponseEntity<List<Empresa>> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(empresas);
			ResponseEntity<List<Empresa>> resposta = new ResponseEntity<>(empresas, HttpStatus.FOUND);
			return resposta;
		}
	}
	
	@PostMapping("/empresa/cadastro")
	public ResponseEntity<?> cadastrarEmpresa(@RequestBody Empresa empresaNova) {
		HttpStatus status = HttpStatus.CONFLICT;
		if (empresaNova.getId() == null) {
			repositorio.save(empresaNova);
			status = HttpStatus.CREATED;
		}
		return new ResponseEntity<>(status);
	}
}
