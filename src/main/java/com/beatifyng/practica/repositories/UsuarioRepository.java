package com.beatifyng.practica.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beatifyng.practica.entities.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	public List<Usuario> findByEmail(String email);
	
	public List<Usuario> findByEmailAndNombre(String email, String nombre);
	
	public List<Usuario> findByGenero(String genero);
	
	public List<Usuario> findByGeneroAndMaculino(String genero, String masculino);
	
	public List<Usuario> findByGeneroAndFemenino(String genero, String femenino);
	
}
