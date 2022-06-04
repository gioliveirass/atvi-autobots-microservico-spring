package com.autobots.automanager.entidades;

import com.autobots.automanager.enumeracoes.PerfilUsuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioPerfil {
	private long id;
	private PerfilUsuario perfil;
}
