package com.beatifyng.practica.services;

import java.util.List;
import java.util.Optional;

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
	
	public void deleteById (int idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	
	}
	
	public Usuario updateUser(Usuario usuario, int idUsuario) {
		Optional<Usuario> optional = usuarioRepository.findById(idUsuario);
		if (optional.isPresent()) {
			return usuarioRepository.save(usuario);
		} else {
			return null;
		}
	
	}
}
