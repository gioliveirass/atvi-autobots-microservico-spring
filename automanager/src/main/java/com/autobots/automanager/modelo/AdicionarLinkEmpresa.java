package com.autobots.automanager.modelo;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.EmpresaControle;
import com.autobots.automanager.entidades.Empresa;

@Component
public class AdicionarLinkEmpresa implements AdicionadorLink<Empresa> {
	@Override
	public void adicionarLink(List<Empresa> lista) {
		for (Empresa empresa : lista) {
			long id = empresa.getId();
			Link linkProprio = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(EmpresaControle.class)
							.obterEmpresa(id))
					.withSelfRel();
			empresa.add(linkProprio);
		}
	}

	@Override
	public void adicionarLink(Empresa objeto) {
		Link linkProprio = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(EmpresaControle.class)
						.obterEmpresas())
				.withRel("empresas");
		objeto.add(linkProprio);
	}
}
