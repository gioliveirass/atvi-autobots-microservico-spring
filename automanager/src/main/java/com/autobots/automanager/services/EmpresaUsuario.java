package com.autobots.automanager.services;

import com.autobots.automanager.adaptadores.UsuarioCadastroAdaptador;
import com.autobots.automanager.entidades.Usuario;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaUsuario {
	private long id;
	private UsuarioCadastroAdaptador usuarioAdaptar;
}
