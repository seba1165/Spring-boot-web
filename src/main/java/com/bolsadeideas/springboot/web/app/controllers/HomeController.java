package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class HomeController {

	// localhost:8080/index ejecuta este metodo
	// Si se omite el method, queda como Get automaticamente
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String home(){
//		return "home";
//	}
	// Otra forma pero que funciona igual
//	@GetMapping(value = "/index")
//	public String home() {
//		return "home";
//	}

	@GetMapping({ "/home", "/", "", "/index" })
	public String home(Model model) {
		model.addAttribute("titulo", "hola Spring Framework");
		return "home";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("Sebastian");
		usuario.setApellido("Calderon");
		usuario.setCorreo("sebatian1165@gmail.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de usuarios: ");

		return "listar";
	}
	
	@ModelAttribute("usuarios")
	private List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Cristobal", "Vasquez", "correo@correo.cl"));
		usuarios.add(new Usuario("Ramon", "Perez", "correo@correo.cl"));
		usuarios.add(new Usuario("Claudio", "Alfred", "correo@correo.cl"));
		return usuarios;
	}

}
