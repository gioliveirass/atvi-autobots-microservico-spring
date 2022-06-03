package com.autobots.automanager.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.autobots.automanager.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
}

