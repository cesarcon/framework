package com.beatifyng.practica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beatifyng.practica.entities.Usuario;
import com.beatifyng.practica.services.UsuarioService;

@RestController
@RequestMapping(value = "/users")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> pruebaGet() {
		return new ResponseEntity<>(usuarioService.consultarTodos(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
	}
	@GetMapping("/consultar-por-email/{email}/{nombre}")
	public ResponseEntity<List<Usuario>> consultarPorEmailNombre(@PathVariable String email,
			@PathVariable String nombre){
		return new ResponseEntity<> (usuarioService.buscarPorEmailNombre(email, nombre), HttpStatus.OK);
	}
	
	@GetMapping("/consultar-por-genero/{genero}")
	public ResponseEntity<List<Usuario>> consultarPorGenero(@PathVariable String genero){
		return new ResponseEntity<> (usuarioService.buscarPorGenero(genero), HttpStatus.OK);
	}
	
	@DeleteMapping (value="/{idUsuario}/delete")
	public ResponseEntity<Object> deleteById (@PathVariable int idUsuario){
		this.usuarioService.deleteById(idUsuario);
		return ResponseEntity.ok(Boolean.TRUE);
	}

	@PutMapping (value= "/update")
	public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario, @RequestParam int id){
		Usuario usuarioActualizado = usuarioService.updateUser(usuario, id);
		if (usuarioActualizado == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
		}
		
	}

}
