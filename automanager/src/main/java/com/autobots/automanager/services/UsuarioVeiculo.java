package com.autobots.automanager.services;

import com.autobots.automanager.entidades.Usuario;
import com.autobots.automanager.entidades.Veiculo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioVeiculo {
	private long id;
	private Veiculo veiculo;
}
