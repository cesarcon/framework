package com.beatifyng.practica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beatifyng.practica.entities.Usuario;
import com.beatifyng.practica.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario crearUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> consultarTodos(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public List<Usuario> buscarPorEmailNombre(String email, String nombre){
		return usuarioRepository.findByEmailAndNombre(email, nombre);
	}
	
	public List<Usuario> buscarPorGeneroMaculino(String genero, String masculino){
		return usuarioRepository.findByGeneroAndMaculino(genero, masculino);
	}
	
	public List<Usuario> buscarPorGeneroFemenino(String genero, String femenino){
		return usuarioRepository.findByGeneroAndFemenino(genero, femenino);
	}
	
}
