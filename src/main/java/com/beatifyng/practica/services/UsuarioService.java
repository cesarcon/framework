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
	
	public List<Usuario> buscarPorGenero(String genero){
		return usuarioRepository.findByGenero(genero);
	}
	
	public Usuario deleteById (int idUsuario) {
		return usuarioRepository.deleteById(idUsuario);
	
	}
}
