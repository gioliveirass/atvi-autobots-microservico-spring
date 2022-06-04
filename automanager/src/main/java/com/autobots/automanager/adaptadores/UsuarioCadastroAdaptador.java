package com.autobots.automanager.adaptadores;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.autobots.automanager.entidades.CredencialUsuarioSenha;
import com.autobots.automanager.entidades.CredencialCodigoBarra;
import com.autobots.automanager.entidades.Usuario;

import lombok.Data;

@Data
public class UsuarioCadastroAdaptador implements Adaptador<Usuario> {
	private final BCryptPasswordEncoder codificador = new BCryptPasswordEncoder();
	
	private Usuario usuario;
	private String nomeUsuario;
	private String senha;
	@Override
	public Usuario adaptar() {
		CredencialUsuarioSenha credencialUsuarioSenha = new CredencialUsuarioSenha();
		credencialUsuarioSenha.setNomeUsuario(nomeUsuario);
		credencialUsuarioSenha.setSenha(codificador.encode(senha));
		usuario.getCredenciais().add(credencialUsuarioSenha);
		
		CredencialCodigoBarra credencialCodigoBarra = new CredencialCodigoBarra();
		credencialCodigoBarra.setCodigo(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
		usuario.getCredenciais().add(credencialCodigoBarra);
		return this.usuario;
	}
}
